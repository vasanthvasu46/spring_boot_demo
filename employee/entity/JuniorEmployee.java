package com.employee.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "junior_employee")
public class JuniorEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "job_role", length = 50)
    private String job_role;


    @ManyToOne
    @JoinColumn(name = "seniorEmployee_id")
    private SeniorEmployee seniorEmployee;


    JuniorEmployee() {
    }


    public int getJe_id() {
        return id;
    }

    public void setJe_id(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob_role() {
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }

    @JsonBackReference
    public SeniorEmployee getSeniorEmployee() {
        return seniorEmployee;
    }

    public void setSeniorEmployee(SeniorEmployee seniorEmployee) {
        this.seniorEmployee = seniorEmployee;
    }


}
