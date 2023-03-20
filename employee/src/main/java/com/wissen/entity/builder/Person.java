package com.wissen.entity.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Person {

    private String name;
    private int age;
    private boolean isActive;
    private String role;

    @Builder
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
