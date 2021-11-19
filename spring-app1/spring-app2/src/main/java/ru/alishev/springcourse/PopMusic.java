package ru.alishev.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
//@Scope("prototype") //wont use destroy method
@Scope("singleton")
public class PopMusic implements Music{


    public String getSong(int number) {
        return "Smooth criminal";
    }

    @PostConstruct
    public void initialize(){
        System.out.println("Pop music bean was initialized");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroying pop bean");
    }
}
