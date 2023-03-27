package com.bi.manytomany.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveMain {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(SaveMain.class);
		
		Configuration configuration = new Configuration();
	    configuration.configure("BiManyToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
            
        	session.beginTransaction();
        	
        	Course crse= new Course("course1");
        	
        	logger.info("Saving the course");
        	
        	session.save(crse);
        	
        	Student std1= new Student("hari1","prasanth1","hari1@gmail.com");
        	Student std2= new Student("hari2","prasanth2","hari2@gmail.com");
        	
        	crse.addStudent(std1);
        	crse.addStudent(std2);
        	
        	session.save(std1);
        	session.save(std2);
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
