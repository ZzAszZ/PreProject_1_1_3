package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/leanbase",
                    "root", "dom5132478");
            System.out.println("Connected");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Disconnected");
        }
        return connection;
    }
}
