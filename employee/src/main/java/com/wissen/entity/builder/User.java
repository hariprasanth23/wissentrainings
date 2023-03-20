package com.wissen.entity.builder;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {

    private String name;
    private int age;
}
