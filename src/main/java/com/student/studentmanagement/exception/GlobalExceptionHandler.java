package com.student.studentmanagement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;



@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleStudentNotFound(
            StudentNotFoundException ex) {


        Map<String,Object> error = new HashMap<>();

        error.put("timestamp", LocalDateTime.now());

        error.put("message", ex.getMessage());

        error.put("status", 404);


        return new ResponseEntity<>(
                error,
                HttpStatus.NOT_FOUND
        );

    }



    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {


        Map<String,String> errors = new HashMap<>();


        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {

                    errors.put(
                            error.getField(),
                            error.getDefaultMessage()
                    );

                });


        return new ResponseEntity<>(
                errors,
                HttpStatus.BAD_REQUEST
        );

    }


}