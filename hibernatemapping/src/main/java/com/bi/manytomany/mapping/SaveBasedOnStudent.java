package com.bi.manytomany.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveBasedOnStudent {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(SaveBasedOnStudent.class);		
		
		Configuration configuration = new Configuration();
	    configuration.configure("BiManyToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
            
        	session.beginTransaction();
        	
        	int studentId=2;
        	Student std1= session.get(Student.class,studentId);
        	
        	logger.info("student:"+std1);
        	logger.info("student course:"+std1.getCourses());
        	
        	Course tempCourse2= new Course("Course2");
        	Course tempCourse3= new Course("Course3");
        	
        	tempCourse2.addStudent(std1);
        	tempCourse3.addStudent(std1);
        	
        	logger.info("Saving the Courses");
        	
        	session.save(tempCourse2);
        	session.save(tempCourse3);
        	
        	
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
