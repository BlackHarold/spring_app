package home.blackharold.jdbc.test.course;

import home.blackharold.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Arrays;

public class CreateCourseAndStudentTest {
    public static void main(String[] args) {

//        create factory sesions
        SessionFactory sessionFactory = new Configuration().configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//        create session
        Session session = sessionFactory.getCurrentSession();

        try {
//            start transaction
            session.getTransaction().begin();

//            create the course
            Course course = new Course("MySQL Starter");

//            save the course
            System.out.println("Saving the course: " + course);
            session.save(course);
            System.out.println("The course saved: " + course);

//            create the students
            Student student1 = new Student("John", "Doe", "j.doe@friendface.ru");
            Student student2 = new Student("Mary", "Public", "m.public@friendface.ru");

//            add student to the course
            course.setStudents(Arrays.asList(student1, student2));

//            save the students
            System.out.println("Saving students: " + course.getStudents());
            session.save(student1);
            session.save(student2);
            System.out.println("Students saved: " + course.getStudents());

//            commit transtaction
            session.getTransaction().commit();


        } catch (SessionException e) {
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
