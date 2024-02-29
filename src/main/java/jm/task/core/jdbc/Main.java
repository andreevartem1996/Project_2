package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
//        userDaoJDBC.createUsersTable();   // создание таблицы
//        userDaoJDBC.dropUsersTable();     // удаление таблицы

//        userDaoJDBC.saveUser("Artem", "Andreev", (byte) 27); // добавить пользователя
//        userDaoJDBC.saveUser("Bob", "Johnson", (byte) 25);
//        userDaoJDBC.saveUser("Alice", "Smith", (byte) 30);
//        userDaoJDBC.saveUser("Eve", "Wilson", (byte) 35);

//        userDaoJDBC.removeUserById(2);    // удалить пользователя по id
//        userDaoJDBC.cleanUsersTable();    // удалить всех пользователей таблицы

//        List<User> allUsers = userDaoJDBC.getAllUsers();   // для получения всей таблицы в виде списка
//        for (User u : allUsers) {
//            System.out.println(u.getId() + " - " + u.getName() + " " + u.getLastName() + " - " + u.getAge());
//        }


    }
}
