package home.blackharold.jdbc.test.course;

import home.blackharold.entity.Course;
import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import home.blackharold.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourseAndReviewsTest {
    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.getTransaction().begin();

//            get the course
            int id = 12;
            Course course = session.get(Course.class, id);

//            print the course
            System.out.println(course);

//            print the course reviews
            System.out.println(course.getReviews());

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
