package com.student.studentmanagement.mapper;


import com.student.studentmanagement.dto.StudentResponseDTO;
import com.student.studentmanagement.entity.Student;


public class StudentMapper {


    public static StudentResponseDTO toDTO(Student student) {


        return new StudentResponseDTO(

                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()

        );

    }

}