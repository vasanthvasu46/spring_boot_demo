package io.javabrains.Topics;


import io.javabrains.Course.Course_class;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Topic")
public class Topics_class {
    @Column(name = "Name",nullable = false,unique = true)
    private String name;
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "Price",nullable = false,unique = true)
    private double price;

    @OneToMany(
            mappedBy = "topic",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Course_class> course;

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
