package com.hari.springpractice.xml;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class WebSpringDemo {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "xmlBasedConfiguration.xml");
        Website website = context.getBean("myWebsite",Website.class);
        System.out.println(website.getTechStack());
        System.out.println(website.getDatabaseName());
        context.close();
    }
}
