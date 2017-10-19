package bd.ac.seu.ormdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.getTransaction().begin();
        List<Student> students = new ArrayList<>();

        students.add(new Student(55,"Michael"));
        students.add(new Student(56,"Dave"));
        students.add(new Student(57,"Tom"));
        students.add(new Student(58,"Dinesh"));
        students.add(new Student(59,"Lakshman"));
        students.add(new Student(60,"Cruise"));
        for(Student student : students) {
            session.save(student);

        }

//        List<Student> slist = session.createQuery("from Student").list();
        session.getTransaction().commit();

      // System.out.println(slist);
    }

    public static void main(String args[]) {
        new Main();
    }
}
