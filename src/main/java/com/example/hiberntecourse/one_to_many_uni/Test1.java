package com.example.hiberntecourse.one_to_many_uni;

import com.example.hiberntecourse.one_to_many_uni.entity.Department;
import com.example.hiberntecourse.one_to_many_uni.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Locale;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure()
                .addAnnotatedClass(Department.class)
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            Department department = new Department("Sales",1000,2000);

            Employee emp1 = new Employee("Oleg","Ivanov",1000);
            Employee emp2 = new Employee("Andrei","Sidorov",1200);

            department.addEmployeeToDepartment(emp1);
            department.addEmployeeToDepartment(emp2);

            session.save(department);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
