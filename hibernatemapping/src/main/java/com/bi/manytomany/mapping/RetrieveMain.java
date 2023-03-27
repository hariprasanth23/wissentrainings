package com.bi.manytomany.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveMain {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(RetrieveMain.class);
		
		Configuration configuration = new Configuration();
	    configuration.configure("BiManyToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
            
        	session.beginTransaction();
        	
        	int studentId=2;
        	Student tempStudent = session.get(Student.class, studentId);
        	
        	logger.info("student retrieving"+tempStudent);
        	
        	logger.info("student courses"+tempStudent.getCourses());
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
