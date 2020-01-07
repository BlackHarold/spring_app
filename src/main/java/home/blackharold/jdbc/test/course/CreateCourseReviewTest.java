package home.blackharold.jdbc.test.course;

import home.blackharold.entity.Course;
import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import home.blackharold.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseReviewTest {
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

            Course course = new Course("Hibernate for dummies");

            course.add(new Review("it's awesome course! I like it!"));
            course.add(new Review("i'm very sad!"));

            System.out.println("Saving the course");
            System.out.println(course);
            System.out.println("reviews: " + course.getReviews());
            session.save(course);

            session.getTransaction().commit();
            System.out.println("Done!");

        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
