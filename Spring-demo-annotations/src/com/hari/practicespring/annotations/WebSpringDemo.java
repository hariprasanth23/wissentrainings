package com.hari.practicespring.annotations;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class WebSpringDemo {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "com/hari/practicespring/applicationContext.xml");
        Website website = context.getBean("angularStack",Website.class);
        System.out.println(website.getTechStack());
        System.out.println(website.getDatabaseName());
        context.close();
    }
}
