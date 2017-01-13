package com.epam.hibernate.thread;

import com.epam.hibernate.model.Employee1;
import com.epam.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Date;

/**
 * Created by Konstantin_Yalovik on 1/13/2017.
 */
public class SaveThread extends Thread{

    @Override
    public void run() {
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Employee1 employee = new Employee1();

        employee.setName("Hibernate");
        employee.setInsertTime(new Date());
        employee.setRole("developer");
        employee.setSalary(350);

        System.out.println("sleep before adding new employee");
        try {
            sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("adding new employee");
        session.save(employee);

        session.getTransaction().commit();

        sessionFactory.close();
    }
}
