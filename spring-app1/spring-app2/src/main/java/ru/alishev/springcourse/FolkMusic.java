package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

//@Component("someFolk")
public class FolkMusic implements Music{ //bean id by default is folkMusic
    @Override
    public String getSong(int number) {
        return "any noise";
    }
}
