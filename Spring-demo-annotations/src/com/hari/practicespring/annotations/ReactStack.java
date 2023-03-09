package com.hari.practicespring.annotations;

import org.springframework.stereotype.Component;

@Component
public class ReactStack implements Website{

    private DatabaseService databaseService;

    public ReactStack(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    @Override
    public String getTechStack() {
        return "React Stack ";
    }

    @Override
    public String getDatabaseName() {
        return "React "+ databaseService.getDatabase();
    }
}
