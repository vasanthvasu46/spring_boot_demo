package com.swagger.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", unique = true)
    @ApiModelProperty(notes = "Student ID (Auto generated . Don't want to enter the id", example = "0", required = false)
    private int id;
    @Column(name = "student_name", length = 100)
    @ApiModelProperty(notes = "Student Name", example = "Aakash", required = true)
    private String name;
    @Column(name = "gender")
    @ApiModelProperty(notes = "Student Gender", example = "Male", required = true)
    private String gender;
    @Column(name = "grade")
    @ApiModelProperty(notes = "Student Grade", example = "A+", required = true)
    private String grade;

    public Students() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
