package br.com.armazem.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
 
            try {
                Configuration annotation = new Configuration();
                annotation.configure();
                
                @SuppressWarnings("unused")
				ServiceRegistry serviceRegistry = (ServiceRegistry) new StandardServiceRegistryBuilder()
                		.applySettings(annotation.getProperties()).build();
                sessionFactory = annotation.configure().buildSessionFactory();

            } catch (Throwable ex) {
               
                System.out.println("Erro ao inicar o Hibernate " + ex);
                throw new ExceptionInInitializerError(ex);
            }

            return sessionFactory;
            
        } else {
            return sessionFactory;
        }
    }
}