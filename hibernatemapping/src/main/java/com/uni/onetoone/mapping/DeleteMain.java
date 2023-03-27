package com.uni.onetoone.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteMain {
	
public static void main(String [] args) {
		
	Logger logger = Logger.getLogger(DeleteMain.class);
		
		Configuration configuration = new Configuration();
	    configuration.configure("UniOneToOne.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
        	session.beginTransaction();
        	
        	int theId=1;
        	Employee emp=session.get(Employee.class, theId);
        	
        	logger.info("Found instructor: "+emp);
        	
        	if(emp != null) {
        		
        		logger.info("Deleting: "+emp);
        	
        		session.delete(emp);
        	}
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	
        	 session.close();  
        	
        }
        	
        	
        }

}
