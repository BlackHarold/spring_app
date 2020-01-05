package home.blackharold.jdbc;

import home.blackharold.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ChangeAllEmails {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate/hibernate.cfg.xml").addAnnotatedClass(StudentEntity.class).buildSessionFactory();
        Session session = factory.getCurrentSession();


        try {
            session.beginTransaction();
            List<StudentEntity> students = session.createQuery("from StudentEntity").getResultList();

            for (StudentEntity student : students) {
                System.out.println("student: " + student);
                String firstCharAtName = String.valueOf(student.getFirstName().charAt(0)).toLowerCase();
                String lastName = student.getLastName().toLowerCase();
                String emailAddress = String.format("%s.%s@friendface.ru", firstCharAtName, lastName);
                System.out.println("email: " + emailAddress);
                session.createQuery("update StudentEntity s set s.email='" + emailAddress + "' where s.id='" + student.getId() + "'").executeUpdate();
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
    }
}
