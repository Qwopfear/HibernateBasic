package com.example.hiberntecourse.hibernate_introduction;

import com.example.hiberntecourse.hibernate_introduction.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{
            int empId = 1;

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 10);

            session.getTransaction().commit();


            System.out.println("My employee: " + employee);
        }finally {
            factory.close();
        }
    }
}
