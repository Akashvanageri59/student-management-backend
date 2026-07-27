package com.student.studentmanagement.controller;


import com.student.studentmanagement.dto.StudentRequestDTO;
import com.student.studentmanagement.dto.StudentResponseDTO;
import com.student.studentmanagement.service.StudentService;


import jakarta.validation.Valid;


import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;


import java.util.List;



@CrossOrigin(origins = "http://localhost:5173")

@RestController

@RequestMapping("/students")

public class StudentController {



    private final StudentService studentService;



    public StudentController(StudentService studentService) {

        this.studentService = studentService;

    }




    @GetMapping

    public List<StudentResponseDTO> getAllStudents() {


        return studentService.getAllStudents();

    }





    @PostMapping

    public StudentResponseDTO saveStudent(

            @Valid @RequestBody StudentRequestDTO student) {


        return studentService.saveStudent(student);

    }





    @GetMapping("/{id}")

    public StudentResponseDTO getStudentById(

            @PathVariable Long id) {


        return studentService.getStudentById(id);

    }





    @PutMapping("/{id}")

    public StudentResponseDTO updateStudent(

            @PathVariable Long id,

            @Valid @RequestBody StudentRequestDTO student) {


        return studentService.updateStudent(id, student);

    }





    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteStudent(

            @PathVariable Long id) {


        studentService.deleteStudent(id);


        return ResponseEntity.ok(
                "Student deleted successfully!"
        );

    }


}