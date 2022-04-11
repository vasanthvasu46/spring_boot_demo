package com.Employee.Model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Senior_Employee")
public class SeniorEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "Name", length = 50)
    private String name;
    @Column(name = "Job_Role", length = 50)
    private String job_role;

    @OneToMany(
            mappedBy = "seniorEmployee",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<JuniorEmployee> juniorEmployeeList;

    SeniorEmployee(){}

    public SeniorEmployee(int id, String name, String job_role) {
        super();
        this.id = id;
        this.name = name;
        this.job_role = job_role;
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
        return job_role;
    }

    public void setJob_role(String job_role) {
        this.job_role = job_role;
    }
}