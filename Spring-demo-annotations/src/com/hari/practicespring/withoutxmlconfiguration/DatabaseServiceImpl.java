package com.hari.practicespring.withoutxmlconfiguration;

import org.springframework.stereotype.Component;

@Component("databaseServiceImpl")
public class DatabaseServiceImpl implements DatabaseService {
    @Override
    public String getDatabase() {
        return " We are going to use MySql";
    }
}
