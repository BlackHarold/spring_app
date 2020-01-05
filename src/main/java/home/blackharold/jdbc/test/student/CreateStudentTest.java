package home.blackharold.jdbc.test.student;

import home.blackharold.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentTest {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            use the session object to save Java object

            System.out.println("start transaction....");
            StudentEntity student = new StudentEntity("Paul", "Wall", "p.wall@friendface.ru");
//            create transaction
            session.beginTransaction();
//            save the student object
            session.save(student);
//            commit transaction
            session.getTransaction().commit();
            System.out.println("transaction commited....");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
//            close all threads
            session.close();
            factory.close();
        }

    }

}
