package com.employee.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "senior_employee")
public class SeniorEmployee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "job_role", length = 50)
    private String jobRole;
    @Column(name = "salary")
    private int salary;


    @OneToMany(
            mappedBy = "seniorEmployee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JuniorEmployee> juniorEmployeeList;

    public SeniorEmployee() {
    }


    public SeniorEmployee(int id, String name, String jobRole, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.jobRole = jobRole;
        this.salary = salary;
    }

    public int getSe_id() {
        return id;
    }

    public void setSe_id(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_role() {
        return jobRole;
    }

    public void setJob_role(String jobRole) {
        this.jobRole = jobRole;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;

    }

    @JsonManagedReference
    public List<JuniorEmployee> getJuniorEmployeeList() {
        return juniorEmployeeList;
    }

    public void setJuniorEmployeeList(List<JuniorEmployee> juniorEmployeeList) {
        this.juniorEmployeeList = juniorEmployeeList;
    }
}