package io.javabrains.Topics;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topics_class {
    private String name;
    @Id
    private int id;
    private double price;

    Topics_class(){}

    public Topics_class(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
