package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.internal.Util;

public class Main {
    private static UserService userService = new UserServiceImpl();
    private static UserDao userDao = new UserDaoHibernateImpl();
    public static void main(String[] args) {

        userService.createUsersTable();

        userService.saveUser("Name1", "LasrName1", (byte) 18);
        userService.saveUser("Name2", "LastName2", (byte) 28);
        userService.saveUser("Name3", "LastName3", (byte) 38);
        userService.saveUser("Name4", "LastName4", (byte) 48);

        System.out.println(userService.getAllUsers());

        userService.removeUserById(1);

        System.out.println(userService.getAllUsers());

        userService.cleanUsersTable();

        System.out.println(userService.getAllUsers());

        userService.dropUsersTable();

    }
}
