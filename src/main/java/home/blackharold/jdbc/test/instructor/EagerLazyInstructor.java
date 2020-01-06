package home.blackharold.jdbc.test.instructor;

import home.blackharold.entity.Course;
import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazyInstructor {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.getTransaction().begin();

            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println("Instructor: " + instructor);
            System.out.println("Courses:" + instructor.getCourses());

            session.getTransaction().commit();

        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
