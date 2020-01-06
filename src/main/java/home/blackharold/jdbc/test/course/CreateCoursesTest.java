package home.blackharold.jdbc.test.course;

import home.blackharold.entity.Course;
import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class CreateCoursesTest {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.getTransaction().begin();

//            Course course = new Course("spring-boot");
//            session.save(course);

            Instructor instructor = session.get(Instructor.class, 1);
            Course course1 = new Course("Spring Boot");
            Course course2 = new Course("Java EE");

            instructor.setCourses(Arrays.asList(course1, course2));
//            instructor.add(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();


        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
