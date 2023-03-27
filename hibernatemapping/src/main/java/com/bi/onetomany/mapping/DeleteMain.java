package com.bi.onetomany.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMain {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(DeleteMain.class);
		
		Configuration configuration = new Configuration();
	    configuration.configure("BiOneToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
         	session.beginTransaction();
        	
        	int theId=1;
        	
        	Employee emp=session.get(Employee.class,theId);
        	
        	logger.info("Deleting employee"+emp);
        	
        	session.delete(emp);
            
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
