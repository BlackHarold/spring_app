package home.blackharold.jdbc;

import home.blackharold.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyTest {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            use the session object to save Java object
//            create three student object
            System.out.println("Creating students...");
            StudentEntity student1 = new StudentEntity("John", "Doe", "j.doe@friendface.ru");
            StudentEntity student2 = new StudentEntity("Mary", "Publito", "m.publito@friendface.ru");
            StudentEntity student3 = new StudentEntity("Bonita", "Hasselhoff", "b.hasselhoff@friendface.ru");
//            create transaction
            System.out.println("start transaction....");
            session.beginTransaction();
//            save the students objects
            System.out.println("Saving students... ");
            session.save(student1);
            session.save(student2);
            session.save(student3);
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
