package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    // private final Connection connection = Util.getConnection();

    public void createUsersTable() {
        /*
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS users (id int  NOT NULL PRIMARY KEY AUTO_INCREMENT, name VARCHAR(45) NOT NULL, lastName VARCHAR(45) NOT NULL, age INT)");
            System.out.println("The table was created");
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
    }

    public void dropUsersTable() {
        /*
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            System.out.println("The table deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

         */
    }

    public void saveUser(String name, String lastName, byte age) {
/*
        String sql = "INSERT INTO users(name, lastName, age) VALUES(?, ?, ?)";
        try (PreparedStatement ppsm = connection.prepareStatement(sql)){
            ppsm.setString(1, name);
            ppsm.setString(2, lastName);
            ppsm.setByte(3, age);
            ppsm.executeUpdate();
            System.out.println("User " + name + " add to table");
        } catch (SQLException e) {
            e.printStackTrace();
        }

 */
    }

    public void removeUserById(long id) {
/*
        try (PreparedStatement ppsm = connection.prepareStatement("DELETE FROM users WHERE id = ?" )){
            ppsm.setInt(1, (int) id);
            ppsm.executeUpdate();
            System.out.println("User " + id + " deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

 */
    }

    public List<User> getAllUsers() {
/*
        List<User> users = new ArrayList<>();

        String sql = "SELECT id, name, lastName, age from users";
        try (PreparedStatement ppsm = connection.prepareStatement(sql)) {
            ResultSet resultSet = ppsm.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong(1));
                user.setName(resultSet.getString(2));
                user.setLastName(resultSet.getString(3));
                user.setAge(resultSet.getByte(4));

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

 */
        return null;

    }

    public void cleanUsersTable() {
        /*
        try (Statement statement = connection.createStatement()){
            statement.executeUpdate("DELETE FROM users");
            System.out.println("Table Clean");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
         */

    }
}
