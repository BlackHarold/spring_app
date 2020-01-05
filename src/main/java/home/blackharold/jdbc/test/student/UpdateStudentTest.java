package home.blackharold.jdbc.test.student;

import home.blackharold.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentTest {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();
        Session session = null;


        try {

            /**
             * Change first name to the student when his ID is '2'
             */
/*            session = factory.getCurrentSession();
            session.beginTransaction();
            int studentID = 2;
            StudentEntity student = session.get(StudentEntity.class, studentID);
            student.setFirstName("Cornelio");
            session.getTransaction().commit();*/

            /**
             * Change all emails of student
             */
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update StudentEntity set email='foo@friendface.ru'").executeUpdate();
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
