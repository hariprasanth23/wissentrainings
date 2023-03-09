package com.hari.springpractice.xml;

public class AngularStack implements Website{

    private DatabaseService databaseService;

//    public AngularStack(DatabaseService databaseService){
//        this.databaseService = databaseService;
//    }

    public void setDatabaseService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    @Override
    public String getTechStack() {
        return "Angular Stack Class";
    }

    @Override
    public String getDatabaseName() {
        return "Angular "+ databaseService.getDatabase();
    }
}
