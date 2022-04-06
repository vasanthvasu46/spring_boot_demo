package io.javabrains.Course;


import io.javabrains.Topics.Topics_class;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course_class {
    private String name;
    @Id
    private int course_id;
    private double price;

    @ManyToOne
    private Topics_class topic;

    public Topics_class getTopic() {
        return topic;
    }

    public void setTopic(Topics_class topic) {
        this.topic = topic;
    }



    Course_class(){}

    public Course_class(String name, int course_id, double price, int topicId) {
        this.name = name;
        this.course_id = course_id;
        this.price = price;
        this.topic=new Topics_class("", topicId,0.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return course_id;
    }

    public void setId(int course_id) {
        this.course_id = course_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
