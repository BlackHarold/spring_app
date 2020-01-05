package home.blackharold.jdbc.test.instructor;

import home.blackharold.entity.Instructor;
import home.blackharold.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorTest {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
//            use the session object to save Java object
            System.out.println("start transaction....");
            Instructor instructor1 = new Instructor("Chad", "Derby", "c.derby@friendface.ru");
            InstructorDetail instructorDetail1 = new InstructorDetail("http://www.DerbyChannel.com/youtube", "code");
//            associate the objects
            instructor1.setInstructorDetail(instructorDetail1);

            Instructor instructor2 = new Instructor("Madhu", "Patel", "m.patel@friendface.ru");
            InstructorDetail instructorDetail2 = new InstructorDetail("http://www.Madhu.com/youtube", "flowers");
//            associate the objects
            instructor2.setInstructorDetail(instructorDetail2);

            //            start transaction
            session.beginTransaction();
//            save the instructor object. Also this will save the details object
//            because of CascadeType.ALL
            session.save(instructor1);
            session.save(instructor2);
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
