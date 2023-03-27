package com.uni.onetomany.mapping;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SaveMain {

	public static void main(String[] args) {
		
		Logger logger = Logger.getLogger(SaveMain.class);
		
		
		Configuration configuration = new Configuration();
	    configuration.configure("UniOneToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
            
        	session.beginTransaction();
        	
        	Product prd = new Product("PS5","Sony");
       
        	prd.addReview(new Review("nice product"));
        	prd.addReview(new Review("good product"));
        	prd.addReview(new Review("worst product"));
        	
        	logger.info("Saving the product");
        	
        	logger.info(prd);
        	
        	logger.info(prd.getReviews());
        	
        	session.save(prd);
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
