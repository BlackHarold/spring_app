package home.blackharold.jdbc;

import home.blackharold.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentTest {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            use the session object to save Java object

            System.out.println("start transaction....");
            StudentEntity student = new StudentEntity("Pavel", "Morozov", "p.morozov@friendface.ru");
//            create transaction
            session.beginTransaction();
//            save the student object
            session.save(student);
//            commit transaction
            session.getTransaction().commit();
            System.out.println("transaction commited....");

//            new code
//            find out the object's id: primary key
            System.out.println("find student by id: " + student.getId());
//            now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
//            retrieve student based on the id: primary key
            System.out.println("Getting student with id: " + student.getId());
            StudentEntity myStudent = session.get(StudentEntity.class, student.getId());
            System.out.println("Get complete: " + myStudent);
//            commit transaction
            session.getTransaction().commit();
            System.out.println("done!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
//            close all threads
            session.close();
            factory.close();
        }

    }

}
