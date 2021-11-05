package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь

        UserService userService = new UserServiceImpl();

        userService.createUsersTable();          // создание таблицы

        userService.saveUser("Alexander", "Petrov", (byte) 30);
        userService.saveUser("Andrey", "Ivanov", (byte) 20);
        userService.saveUser("Nina", "Sergeeva", (byte) 25);
        userService.saveUser("Elena", "Rusova", (byte) 28);


        List<User> userList = userService.getAllUsers();   // получаем всех юзеров в лист
        System.out.println(userList);

        userService.cleanUsersTable();                     // очищаем таблицу

        userService.dropUsersTable();                       // удаление таблицы
    }
}
