package home.blackharold.jdbc;

import home.blackharold.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class FindStudentTest {

    public static void main(String[] args) {

        List<StudentEntity> students;
        SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            System.out.println("start transaction....");
//            create transaction
            session.beginTransaction();

            /**
             * Display all students
             */
            students = session.createQuery("from StudentEntity").getResultList();
            for (StudentEntity student : students) {
                System.out.println("student: " + student);
            }

            /**
             * Display all students WHERE first name is 'Pavel' OR last name is 'Doe'
             */
            students = session.createQuery("from StudentEntity s where" +
                    " s.firstName='Pavel' or s.lastName='Doe'").getResultList();
            for (StudentEntity student : students) {
                System.out.println("where first name 'Pavel' or last name 'Doe': " + student);
            }

            /**
             * Display all students WHERE email ends with 'friendface.ru'
             */
            students = session.createQuery("from StudentEntity s where s.email like '%friendface.ru'").getResultList();
            for (StudentEntity student : students) {
                System.out.println("where email ends with 'friendface.ru': " + student);
            }

//            commit transaction
            session.getTransaction().commit();
            System.out.println("transaction commited....");
            System.out.println("done!");
        } catch (
                Exception e) {
            System.out.println(e.getMessage());
        } finally {
//            close all threads
            session.close();
            factory.close();
        }
    }
}
