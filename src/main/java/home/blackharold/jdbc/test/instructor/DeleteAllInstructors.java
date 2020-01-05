package home.blackharold.jdbc.test.instructor;

import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteAllInstructors {
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

//            start transaction
            session.beginTransaction();

//            delete the instructor object. Also this will save the details object
//            because of CascadeType.ALL
            session.createQuery("delete from Instructor").executeUpdate();
            session.createQuery("delete from InstructorDetail").executeUpdate();

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
