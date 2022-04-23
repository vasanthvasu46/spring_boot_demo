package com.employeeee.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "senior_employee")
public class SeniorEmployee {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    @ApiModelProperty(notes = "Senior employee ID (Auto generated . Don't want to enter the id)", example = "0", required = false)
    private int id;

    @Column(name = "name", length = 50)
    @ApiModelProperty(notes = "Senior employee name", example = "Dravid", required = true)
    private String name;

    @Column(name = "salary")
    @ApiModelProperty(notes = "Senior employee salary", example = "50000", required = true)
    private int salary;

    @Column(name = "location")
    private String location;


    @OneToMany(mappedBy = "seniorEmployee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<JuniorEmployee> juniorEmployeeList;

    public SeniorEmployee() {
    }


    public SeniorEmployee(int id, String name, int salary, String location) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.location = location;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @JsonManagedReference
    public List<JuniorEmployee> getJuniorEmployeeList() {
        return juniorEmployeeList;
    }

    public void setJuniorEmployeeList(List<JuniorEmployee> juniorEmployeeList) {
        this.juniorEmployeeList = juniorEmployeeList;
    }
}