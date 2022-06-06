package com.example.hiberntecourse.one_to_one;

import com.example.hiberntecourse.one_to_one.entity.Details;
import com.example.hiberntecourse.one_to_one.entity.Employee;
import org.hibernate.SessionFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Details.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            session.createQuery("DELETE Employee WHERE name = 'Diana'").executeUpdate();
            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }



    }
}
