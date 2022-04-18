package logging.entity;


import javax.persistence.*;

@Entity
@Table(name = "Senior_Employee")
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "job_role", length = 50)
    private String job_role;
    @Column(name = "salary")
    private int salary;

    Employee(){}

    public Employee(int id, String name, String job_role, int salary) {
        super();
        this.id = id;
        this.name = name;
        this.job_role = job_role;
        this.salary=salary;
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
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;

    }


}