package GlobalExceptionHandling.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {

    @Id

    private int id;
    private String name;
    private int age;

    Students(){}

    public Students(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
