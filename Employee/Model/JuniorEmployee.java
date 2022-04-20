package com.Employee.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "Junior_Employee")
public class JuniorEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int je_id;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Job_Role", length = 50)
    private String job_role;


    @ManyToOne
    @JoinColumn(name = "seniorEmployee_id")
    private SeniorEmployee seniorEmployee;


    JuniorEmployee() {
    }


    public int getJe_id() {
        return je_id;
    }

    public void setJe_id(int je_id) {
        this.je_id = je_id;
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
