package com.student.studentmanagement.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotBlank(message = "Name cannot be empty")
    private String name;



    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Enter a valid email")
    private String email;



    @NotBlank(message = "Course cannot be empty")
    private String course;




    public Student() {

    }



    public Student(Long id, String name, String email, String course) {

        this.id = id;

        this.name = name;

        this.email = email;

        this.course = course;

    }




    public Long getId() {

        return id;

    }



    public void setId(Long id) {

        this.id = id;

    }



    public String getName() {

        return name;

    }



    public void setName(String name) {

        this.name = name;

    }



    public String getEmail() {

        return email;

    }



    public void setEmail(String email) {

        this.email = email;

    }



    public String getCourse() {

        return course;

    }



    public void setCourse(String course) {

        this.course = course;

    }


}