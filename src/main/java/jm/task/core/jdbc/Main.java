package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static UserService userService = new UserServiceImpl();
    private static UserDao userDao = new UserDaoJDBCImpl();
    public static void main(String[] args) {

        userService.createUsersTable();

        userService.saveUser("Name1", "LasrName1", (byte) 18);
        userService.saveUser("Name2", "LastName2", (byte) 28);
        userService.saveUser("Name3", "LastName3", (byte) 38);
        userService.saveUser("Name4", "LastName4", (byte) 48);

        System.out.println(userDao.getAllUsers());

        userService.removeUserById(1);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        System.out.println(userService.getAllUsers());

        userService.dropUsersTable();

    }
}
