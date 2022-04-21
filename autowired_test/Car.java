package io.autowired_test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("car")
public class Car implements Vehicle {

    @Override
    public void display_name() {
        System.out.println("Displaying Car name");
    }
}
