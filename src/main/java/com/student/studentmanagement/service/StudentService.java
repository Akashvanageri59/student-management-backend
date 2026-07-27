package com.student.studentmanagement.service;


import com.student.studentmanagement.dto.StudentRequestDTO;
import com.student.studentmanagement.dto.StudentResponseDTO;
import com.student.studentmanagement.entity.Student;
import com.student.studentmanagement.exception.StudentNotFoundException;
import com.student.studentmanagement.mapper.StudentMapper;
import com.student.studentmanagement.repository.StudentRepository;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;



@Service
public class StudentService {


    private static final Logger log =
            LoggerFactory.getLogger(StudentService.class);



    private final StudentRepository studentRepository;



    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;

    }



    // GET ALL

    public List<StudentResponseDTO> getAllStudents() {


        log.info("Fetching all students");


        return studentRepository.findAll()

                .stream()

                .map(StudentMapper::toDTO)

                .collect(Collectors.toList());

    }




    // CREATE STUDENT

    public StudentResponseDTO saveStudent(StudentRequestDTO request) {


        log.info("Saving student with email: {}", request.getEmail());


        Student student = new Student();


        student.setName(request.getName());

        student.setEmail(request.getEmail());

        student.setCourse(request.getCourse());


        Student savedStudent = studentRepository.save(student);


        return StudentMapper.toDTO(savedStudent);

    }




    // GET BY ID

    public StudentResponseDTO getStudentById(Long id) {


        log.info("Fetching student with id: {}", id);


        Student student = studentRepository.findById(id)

                .orElseThrow(() ->
                        new StudentNotFoundException(id)
                );


        return StudentMapper.toDTO(student);

    }





    // UPDATE STUDENT

    public StudentResponseDTO updateStudent(
            Long id,
            StudentRequestDTO request) {


        log.info("Updating student with id: {}", id);



        Student student = studentRepository.findById(id)

                .orElseThrow(() ->
                        new StudentNotFoundException(id)
                );



        student.setName(request.getName());

        student.setEmail(request.getEmail());

        student.setCourse(request.getCourse());



        Student updatedStudent =
                studentRepository.save(student);



        return StudentMapper.toDTO(updatedStudent);

    }





    // DELETE STUDENT

    public void deleteStudent(Long id) {


        log.info("Deleting student with id: {}", id);



        Student student = studentRepository.findById(id)

                .orElseThrow(() ->
                        new StudentNotFoundException(id)
                );



        studentRepository.delete(student);


    }


}


