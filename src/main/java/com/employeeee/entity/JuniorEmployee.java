package com.employeeee.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "junior_employee")
public class JuniorEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty(notes = "Junior employee ID (Auto generated . Don't want to enter the id)", example = "0", required = false)
    private int id;

    @Column(name = "name", length = 50)
    @ApiModelProperty(notes = "Junior employee name", example = "Dhoni", required = true)
    private String name;

    @Column(name = "location")
    private String location;


    @ManyToOne
    @JoinColumn(name = "seniorEmployee_id")
    private SeniorEmployee seniorEmployee;


    public JuniorEmployee() {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonBackReference
    public SeniorEmployee getSeniorEmployee() {
        return seniorEmployee;
    }

    public void setSeniorEmployee(SeniorEmployee seniorEmployee) {
        this.seniorEmployee = seniorEmployee;
    }


}
