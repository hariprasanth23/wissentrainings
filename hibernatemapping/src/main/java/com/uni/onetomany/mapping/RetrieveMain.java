package com.uni.onetomany.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RetrieveMain {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(RetrieveMain.class);
		
		Configuration configuration = new Configuration();
	    configuration.configure("UniOneToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
            
        	session.beginTransaction();
        	
        	int theId=1;
        	Product prd = session.get(Product.class, theId);
        	
        	logger.info(prd);
        	
        	logger.info(prd.getReviews());
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
