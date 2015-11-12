package com.es.assurance.persistence;

import java.io.File;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Christophe.KALMAN on 04.11.2015.
 */
public class HibernateUtil{

    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static org.apache.log4j.Logger log = Logger.getLogger(HibernateUtil.class);

    static SessionFactory buildSessionFactory() {
    	File f = loadFromFile();
    	
        try {
            // Create the SessionFactory from hibernate.cfg.xml
        	if(!f.exists()){
        		return new Configuration().configure().buildSessionFactory();
        	}else{
        		return new Configuration().configure(f).buildSessionFactory();
        	}            
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            log.error("Initial SessionFactory creation failed.", ex.getCause());
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
    
    private static File loadFromFile(){
    	File f = new File("./config/hibernate.cfg.xml");
    	return f;
    }
}
