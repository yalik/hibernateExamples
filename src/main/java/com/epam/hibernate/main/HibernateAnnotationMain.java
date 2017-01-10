package com.epam.hibernate.main;

import com.epam.hibernate.model.Employee1;
import com.epam.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * Created by Konstantin_Yalovik on 1/5/2017.
 */
public class HibernateAnnotationMain {
    public static void main(String[] args) {

        Employee1 employee = new Employee1();
        employee.setName("Kostya");
        employee.setRole("Developer");
        employee.setInsertTime(new Date());

        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        session.save(employee);

        session.getTransaction().commit();

        System.out.println("-----------------------" + employee.getId() + "-------------------------");

        session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        session.save(employee);
    }
}
