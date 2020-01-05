package home.blackharold.jdbc.test.student;

import home.blackharold.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentTest {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();
        Session session = null;

        try {

            /**
             * Delete student by ID
             */
            int studentID = 1;
            session = factory.getCurrentSession();
            session.beginTransaction();

            /**
             * first method
             */
            StudentEntity student = session.get(StudentEntity.class, studentID);
            session.delete(student);

            /**
             * second method
             */
            session.createQuery("delete from StudentEntity where id=" + studentID).executeUpdate();

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
