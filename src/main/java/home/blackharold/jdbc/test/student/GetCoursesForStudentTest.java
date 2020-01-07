package home.blackharold.jdbc.test.student;

import home.blackharold.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;
import java.util.List;

public class GetCoursesForStudentTest {
    public static void main(String[] args) {

//        create factory sesions
        SessionFactory sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//        create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            start transaction
            session.getTransaction().begin();

            Student student = session.get(Student.class, 2);

            List<Course> courses = student.getCourses();
            System.out.println("All courses of the student id=" + student.getId() + ": " + courses);


//            commit transtaction
            session.getTransaction().commit();


        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
