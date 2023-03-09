package com.hari.practicespring.annotations;

import org.springframework.stereotype.Component;

@Component
public class DatabaseServiceImpl implements DatabaseService{
    @Override
    public String getDatabase() {
        return " We are going to use MySql";
    }
}
