package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
    public void createUsersTable() {
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDaoJDBC.saveUser("Ivan", "Ivanov", (byte) 5);
//        userDaoJDBC.saveUser("Bob", "Johnson", (byte) 25);
//        userDaoJDBC.saveUser("Alice", "Smith", (byte) 30);
//        userDaoJDBC.saveUser("Eve", "Wilson", (byte) 35);
    }

    public void removeUserById(long id) {
        userDaoJDBC.removeUserById(2);
    }

    public List<User> getAllUsers() {
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        userDaoJDBC.cleanUsersTable();
    }
}
