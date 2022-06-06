package com.example.hiberntecourse.one_to_one;

import com.example.hiberntecourse.one_to_one.entity.Employee;
import com.example.hiberntecourse.one_to_one.entity.Details;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Details.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();
            long phoneNumber = 72345234;
            for (List <String> ps : List.of(
                    List.of("kevin ", "Gideu"),
                    List.of("Artem","Durant"),
                    List.of("Nikita","LeBron"),
                    List.of("Viktor","Kokorin"),
                    List.of("Joe","Dzigurda"),
                    List.of("Igor","Pivovarov"),
                    List.of("James","Plushenko"))) {
                Details details = new Details("Moskow",String.valueOf(phoneNumber),
                        ps.get(0).toLowerCase(Locale.ROOT).charAt(1) + ps.get(1).substring(0,3) + "@gmail.com");
                Employee employee = new Employee(ps.get(0), ps.get(1), "IT",500 + (int)(Math.random() * 3000));

                details.setEmployee(employee);
                employee.setEmpDetail(details);
                session.save(details);
                phoneNumber+= 1111;
            }


            session.getTransaction().commit();


        }finally {
            session.close();
            factory.close();
        }
    }
}
