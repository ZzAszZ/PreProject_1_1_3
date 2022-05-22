package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

   private static Session session = getSessionFactory().openSession();
   private static Transaction ta = session.beginTransaction();   // Не могу понять вынести вот так вот транзакцию можно
                                                                    // или лучше так не делать ?


    public UserDaoHibernateImpl() {

    }



    @Override
    public void createUsersTable() {

        session.createNativeQuery("CREATE TABLE IF NOT EXISTS leanbase.users" +
                " (id mediumint not null auto_increment, name VARCHAR(45), " +
                "lastname VARCHAR(45), " +
                "age tinyint, " +
                "PRIMARY KEY (id))").executeUpdate();
        ta.commit();
        System.out.println("Table create!");
        session.close();


    }

    @Override
    public void dropUsersTable() {

        session.createNativeQuery("DROP TABLE IF EXISTS leanbase.users").executeUpdate();
        ta.commit();
        System.out.println("Table delete!");
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        session.save(new User(name, lastName, age));
        ta.commit();
        System.out.println("User save!");
        session.close();

    }

    @Override
    public void removeUserById(long id) {

        session.delete(session.get(User.class, id));
        ta.commit();
        System.out.println("User" + id + "delete!");
        session.close();

    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = (List<User>)  getSessionFactory().openSession().createQuery("From User").list();
        System.out.println(users.toString());
        ta.commit();
        return users;

    }

    @Override
    public void cleanUsersTable() {

        session.createNativeQuery("TRUNCATE TABLE leanbase.users").executeUpdate();
        ta.commit();
        System.out.println("Table cleaned!");
        session.close();

    }
}
