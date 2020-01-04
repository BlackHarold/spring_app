package home.blackharold.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;


/**
 * Just for test connection
 */
public class TestJdbc {

    public static void main(String[] args) {
        System.out.println("timezone: " + TimeZone.getTimeZone("Europe/Moscow"));
        String DBDriver = "com.mysql.cj.jdbc.Driver";
//        String jdbcUrl = "jdbc:mysql://localhost:3306";
//        fix for timezone connection
//        String jdbcUrl = "jdbc:mysql://localhost:3306?serverTimezone=" + TimeZone.getDefault().getID();
//        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=Europe/Moscow";
        String user = "hbstudent";
        String password = "hbstudent";


        try {
            Class.forName(DBDriver);
            System.out.println("Connecting to db... ");
            Connection connection = DriverManager.getConnection(jdbcUrl, user, password);
            System.out.println("Connection is open? " + !connection.isClosed());
            connection.close();
            System.out.println("Connection is open? " + !connection.isClosed());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
