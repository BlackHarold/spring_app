package home.blackharold.jdbc.test.instructor;

import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ReturnInstructorByDetail {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        Transaction transaction = session.getTransaction();

        try {
//            use the session object to save Java object
            System.out.println("start transaction....");
            transaction.begin();

            int id = 1;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

//            print detail
            System.out.println("instructorDetail: " + instructorDetail);
//            print the associated instructor
            System.out.println("the associated instructor: " + instructorDetail.getInstructor());

//            end of transaction
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
//            close all threads
            session.close();
            factory.close();
        }

    }
}
