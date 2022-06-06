package com.example.hiberntecourse.hibernate_introduction;

        import com.example.hiberntecourse.hibernate_introduction.entity.Employee;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.cfg.Configuration;

        import java.util.ArrayList;
        import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try{

            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Employee> employees = session.createQuery("FROM Employee WHERE name='Diana' AND salary > 600").getResultList();

            System.out.println(employees);

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }
}
