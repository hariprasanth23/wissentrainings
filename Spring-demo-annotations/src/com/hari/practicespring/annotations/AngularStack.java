package com.hari.practicespring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AngularStack implements Website{

    private DatabaseService databaseService;

    @Autowired
    public AngularStack(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

//    @Autowired
//    public void setDatabaseService(DatabaseService databaseService){
//        this.databaseService = databaseService;
//    }

    @Override
    public String getTechStack() {
        return "Angular Stack Class";
    }

    @Override
    public String getDatabaseName() {
        return "Angular "+ databaseService.getDatabase();
    }
}
