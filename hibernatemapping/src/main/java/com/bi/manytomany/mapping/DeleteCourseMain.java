package com.bi.manytomany.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseMain {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
	    configuration.configure("BiManyToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
            
        	session.beginTransaction();
        	
        	int courseId=2;
        	
        	Course tempCourse=session.get(Course.class, courseId);
        	
        	session.delete(tempCourse);
        	
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
