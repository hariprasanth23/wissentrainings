package com.bi.onetoone.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetMain {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(GetMain.class);
		
		Configuration configuration = new Configuration();
	    configuration.configure("BiOneToOne.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
        	session.beginTransaction();
        	
        	int theId=2;
        	
        	Address addr = session.get(Address.class, theId);
        	
        	logger.info("address"+addr);
        	
        	logger.info("the associated employee"+addr.getEmployee());
        	
        	session.getTransaction().commit();
        	
        }catch(Exception e){
        	e.printStackTrace();
        	
        }finally {
        	
        	 session.close();  
        	 
        	 sessionfactory.close();
        }

	}

}
