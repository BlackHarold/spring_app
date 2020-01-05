package home.blackharold.jdbc.test.instructor;

import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorTest {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            use the session object to delete Java object
            System.out.println("start transaction....");
            session.beginTransaction();
//            find the object by ID
            Instructor instructor = session.get(Instructor.class, 2);
            //            start transaction
//            delete the instructor object. Also this will save the details object
//            because of CascadeType.ALL
            session.delete(instructor);
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
