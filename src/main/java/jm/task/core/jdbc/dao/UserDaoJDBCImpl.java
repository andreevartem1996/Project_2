package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Statement statement;
        String sqlCommand = "CREATE TABLE IF NOT EXISTS user (id BIGINT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20)," +
                "lastName VARCHAR(20), age TINYINT)";

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        Statement statement;
        String sqlCommand = "DROP TABLE IF EXISTS user";

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlCommand);
            System.out.println("Таблица удалена");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void saveUser(String name, String lastName, byte age) {
        PreparedStatement preparedStatement;
        String sqlCommand = "INSERT INTO user (name, lastName, age) VALUES (?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sqlCommand);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);

            preparedStatement.executeUpdate();
            System.out.println("User с именем — " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        PreparedStatement preparedStatement;
        String sqlCommand = "DELETE FROM user WHERE id = ?";

        try {
            preparedStatement = connection.prepareStatement(sqlCommand);
            preparedStatement.setLong(1, id);
            int infoDelete = preparedStatement.executeUpdate();
            if (infoDelete > 0) {
                System.out.println("Пользователь с id: " + id + " успешно удален.");
            } else {
                System.out.println("Пользователь с id: " + id + " не найден в таблице.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        PreparedStatement preparedStatement;
        String sqlCommand = "SELECT * FROM user";

        try {
            preparedStatement = connection.prepareStatement(sqlCommand);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void cleanUsersTable() {
        PreparedStatement preparedStatement;
        String sqlCommand = "DELETE FROM user ";

        try {
            preparedStatement = connection.prepareStatement(sqlCommand);
            preparedStatement.executeUpdate();
            System.out.println("Все пользователи удалены из таблицы.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
