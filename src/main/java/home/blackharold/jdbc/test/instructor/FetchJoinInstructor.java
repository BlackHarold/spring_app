package home.blackharold.jdbc.test.instructor;

import home.blackharold.entity.Course;
import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinInstructor {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {
            session.getTransaction().begin();

//            option: Hibernate query with HQL
            int instructorID = 1;

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "join fetch i.courses "
                    + "where i.id=:instructorID", Instructor.class);

            query.setParameter("instructorID", instructorID);

            Instructor instructor = query.getSingleResult();

            System.out.println("instructor: " + instructor);

            session.getTransaction().commit();

        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
