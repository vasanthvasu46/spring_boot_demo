package io.autowired_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Manager {


    @Autowired
    public Manager(@Qualifier("bike1") Vehicle v)
    {
        v.display_name();
    }

}
