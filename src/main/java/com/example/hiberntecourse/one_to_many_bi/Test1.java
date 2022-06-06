package com.example.hiberntecourse.one_to_many_bi;

import com.example.hiberntecourse.one_to_many_bi.entity.Department;
import com.example.hiberntecourse.one_to_many_bi.entity.Employee;
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
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        try (factory; Session session = factory.getCurrentSession()) {
            session.beginTransaction();

//// **************************************************************************
//            Department department = new Department("Design", 1000, 3000);
//
//            Employee emp1 = new Employee("Diana", "Cruel", 2800);
//            Employee emp2 = new Employee("Viktor", "Bogosav", 1700);
//            Employee emp3 = new Employee("Michal", "Lee", 2000);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//            department.addEmployeeToDepartment(emp3);
//
//            session.save(department);
// **************************************************************************
//            Department department = session.get(Department.class,2);
//            session.delete(department);
// **************************************************************************
//            Employee emp = session.get(Employee.class ,4);
//            session.delete(emp);
// **************************************************************************
//            Employee emp = session.get(Employee.class ,1);
//            System.out.println(emp);
//            System.out.println(emp.getDepartment().getEmps());
// **************************************************************************
            System.out.println("Get department");
            Department department = session.get(Department.class,5);
            System.out.println("Show department");
            System.out.println(department);
            System.out.println("Show Employees from department");
            System.out.println(department.getEmps());
// **************************************************************************
//            Department department = session.get(Department.class,3);
//            Employee emp1 = new Employee("Zaur","Creative",1000);
//            Employee emp2 = new Employee("Seva","NotCreative",100);
//
//            department.addEmployeeToDepartment(emp1);
//            department.addEmployeeToDepartment(emp2);
//
//            session.save(emp1);
//            session.save(emp2);
//
//            session.save(department);

//// **************************************************************************

            session.getTransaction().commit();


        }
    }
}
