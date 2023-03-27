package com.bi.onetomany.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveMain {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
	    configuration.configure("BiOneToMany.cfg.xml");
	
	    SessionFactory sessionfactory = configuration.buildSessionFactory();
        Session session = sessionfactory.openSession();
 
        try{
    
        	//first try with commenting 25-38
        	session.beginTransaction();
        	
            Company cmp = new Company("virtusa2","bangalore2");
        	
        	session.save(cmp);
        	
        	int theId=1;
        	
        	Company company=session.get(Company.class,theId);
        	
        	Employee emp1= new Employee("Hari prasanth1");
        	Employee emp2= new Employee("Hari prasanth2");
        	
        	company.add(emp1);
        	company.add(emp2);
        	
        	session.save(emp1);
        	session.save(emp2);
        	
        	session.save(company);
        	
        	session.getTransaction().commit();
        	
        }finally {
        	
        	 session.close();  
        }

	}

}
