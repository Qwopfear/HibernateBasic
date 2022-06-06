package com.example.hiberntecourse.hibernate_introduction;

import com.example.hiberntecourse.hibernate_introduction.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.createQuery("update Employee set salary = 10 " +
                    "where department = 'IT'").executeUpdate();

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }
}
