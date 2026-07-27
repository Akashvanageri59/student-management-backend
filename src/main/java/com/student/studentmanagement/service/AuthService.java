package com.student.studentmanagement.service;

import com.student.studentmanagement.dto.AuthResponse;
import com.student.studentmanagement.dto.LoginRequest;
import com.student.studentmanagement.dto.RegisterRequest;
import com.student.studentmanagement.entity.User;
import com.student.studentmanagement.repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       JwtService jwtService) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    // Register User
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return new AuthResponse(null, "Email already exists");
        }

        User user = new User();

        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return new AuthResponse(
                null,
                "User registered successfully"
        );
    }

    // Login User
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElse(null);

        if (user == null) {
            return new AuthResponse(null, "User not found");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return new AuthResponse(null, "Invalid password");
        }

        // Generate JWT Token
        String token = jwtService.generateToken(user.getEmail());

        return new AuthResponse(
                token,
                "Login successful"
        );
    }
}

