package com.hari.practicespring.withoutxmlconfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.hari.practicespring.withoutxmlconfiguration")
public class JavaConfiguration {
    @Bean
    public DatabaseService databaseService(){
        return new DatabaseServiceImpl();
    }
}
