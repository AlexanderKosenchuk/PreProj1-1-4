package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;
import jm.task.core.jdbc.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    public static final String DB_URL = "jdbc:mysql://localhost:3306/usersdb?useSSL=false";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "root1234";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение с БД установлено.");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    // реализуем здесь Hibernate
     private static SessionFactory sessionFactory = null;

         static {                           // статический блок, что бы инициализировать настройки хибернейт один раз
             try {
                 Properties properties = new Properties();
                 properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/usersdb?useSSL=false");
                 properties.setProperty("hibernate.connection.username", "root");
                 properties.setProperty("hibernate.connection.password", "root1234");
                 properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");

                 sessionFactory = new Configuration().addAnnotatedClass(User.class).addProperties(properties).buildSessionFactory();
             } catch (HibernateException exception) {
                 exception.printStackTrace();
             }
         }
     public static Session getSession() throws HibernateException {
        return sessionFactory.openSession();
     }
}