package com.epam.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Created by Konstantin_Yalovik on 1/10/2017.
 */
public class HibernateUtil {

//    XML based configuration
    private static SessionFactory sessionFactory;
//    Annotation based configuration
    private static SessionFactory sessionAnnotationFactory;
//    Property based configuration
    private static SessionFactory sessionPropertyFactory;

    private static SessionFactory buildSessionFactory(){
//        Create Session factory from hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        System.out.println("Xml configurations loaded");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();

        System.out.println("Hibernate ServiceRegistry created");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    private static SessionFactory buildAnnotationSessionFactory(){
//        Create Session factory from hibernate-annotation.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate-annotation.cfg.xml");

        System.out.println("Annotation configurations loaded");

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                applySettings(configuration.getProperties()).build();

        System.out.println("Hibernate Annotation ServiceRegistry created");

        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static SessionFactory getSessionAnnotationFactory() {
        if (sessionAnnotationFactory == null){
            sessionAnnotationFactory = buildAnnotationSessionFactory();
        }

        return sessionAnnotationFactory;
    }

    public static SessionFactory getSessionPropertyFactory() {
        return sessionPropertyFactory;
    }
}
