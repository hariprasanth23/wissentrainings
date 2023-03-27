package com.bi.onetoone.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SaveMain {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(SaveMain.class);
		
		Configuration configuration = new Configuration();
	    configuration.configure("BiOneToOne.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
        	
        	Address addr = new Address("Vellore","TamilNadu");
        	
        	Employee emp = new Employee("Hari2","Prasanth2","Hari2@gmail.com");
        	
            emp.setAddress(addr);
        	
        	session.beginTransaction();
        	
        	logger.info("saving Employee "+emp);
        	session.save(emp);
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
