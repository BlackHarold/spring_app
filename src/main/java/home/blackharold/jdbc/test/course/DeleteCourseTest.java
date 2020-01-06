package home.blackharold.jdbc.test.course;

import home.blackharold.entity.Course;
import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseTest {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.getTransaction().begin();

            session.delete(session.get(Course.class, 11));

            session.getTransaction().commit();


        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
