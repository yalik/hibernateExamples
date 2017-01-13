package com.epam.hibernate.thread;

import com.epam.hibernate.model.Employee1;
import com.epam.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Konstantin_Yalovik on 1/13/2017.
 */
public class SelectThread extends Thread{

    @Override
    public void run() {
        SessionFactory sessionFactory = HibernateUtil.getSessionAnnotationFactory();

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();
        System.out.println("Select list from employee table");

        List list = session.createCriteria(Employee1.class).
                add(Restrictions.ge("salary",150)).
                add(Restrictions.le("salary", 600)).
                list();

        System.out.println("Select list size before sleep: " + list.size());

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list = session.createCriteria(Employee1.class).
                add(Restrictions.ge("salary",150)).
                add(Restrictions.le("salary", 600)).
                list();

        System.out.println("Select list size after sleep: " + list.size());

        session.getTransaction().commit();

//        session.close();

        session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        list = session.createCriteria(Employee1.class).
                add(Restrictions.ge("salary",150)).
                add(Restrictions.le("salary", 600)).
                list();

        System.out.println("List size in new transaction: " + list.size());

        session.getTransaction().commit();

        sessionFactory.close();
    }
}
