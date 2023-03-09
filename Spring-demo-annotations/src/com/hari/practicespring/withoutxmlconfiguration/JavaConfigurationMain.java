package com.hari.practicespring.withoutxmlconfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigurationMain {
    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfiguration.class);
        DatabaseService databaseService = context.getBean("databaseServiceImpl", DatabaseService.class);

        System.out.println(databaseService.getDatabase());
        context.close();
    }
}
