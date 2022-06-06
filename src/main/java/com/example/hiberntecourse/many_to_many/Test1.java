package com.example.hiberntecourse.many_to_many;

import com.example.hiberntecourse.many_to_many.entity.Child;
import com.example.hiberntecourse.many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

//            Child c1 = new Child("Ivan",10);
//            Child c2 = new Child("Oleg",11);
//            Child c3 = new Child("Kirill",12);
//            Child c4 = new Child("Dima",13);
//            Child c5 = new Child("Denis",14);
//
            Section s1 = new Section("Box");
//            Section s2 = new Section("Basketball");
////
////            s1.addChildrenToSection(c1);
////            s1.addChildrenToSection(c2);
////            s1.addChildrenToSection(c5);
//
//            s2.addChildrenToSection(c3);
//            s2.addChildrenToSection(c4);
//            s2.addChildrenToSection(c5);

//            session.save(s2);

//            *************************************
            Child wounderChild = new Child("Platomei",6);
            Section math = new Section("math");
            Section it = new Section("it");



            wounderChild.addSectionToChild(session.get(Section.class,7));
            wounderChild.addSectionToChild(session.get(Section.class, 8));
            wounderChild.addSectionToChild((Section)session.createQuery("FROM Section WHERE name = 'Basketball'").getResultList().get(0));

            session.save(wounderChild);


            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
