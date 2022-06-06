package com.example.hiberntecourse.hibernate_introduction;

import com.example.hiberntecourse.hibernate_introduction.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory =
                new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction(); // Открытие транзакции

//            Employee emp = session.get(Employee.class, 1);

            session.createQuery("DELETE  Employee WHERE salary < 500").executeUpdate();


            session.getTransaction().commit(); //  Закрытие транзакции
        }finally {
            factory.close();
        }

    }
}
