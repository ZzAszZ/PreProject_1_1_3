package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import org.hibernate.*;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }



    @Override
    public void createUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();
        session.createNativeQuery("CREATE TABLE IF NOT EXISTS users " +
                "(id int  NOT NULL PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(45) NOT NULL, " +
                "lastName VARCHAR(45) NOT NULL, age INT)").executeUpdate();
        ta.commit();
        System.out.println("Table created!");
        session.close();


    }

    @Override
    public void dropUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();
        session.createNativeQuery("DROP TABLE IF EXISTS users").executeUpdate();
        ta.commit();
        System.out.println("Table deleted!");
        session.close();

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();
        session.save(new User(name, lastName, age));
        ta.commit();
        System.out.println("User saved!");
        session.close();

    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();
        session.delete(session.get(User.class, id));
        ta.commit();
        System.out.println("User deleted!");
        session.close();

    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = (List<User>)  getSessionFactory().openSession().createQuery("From User").list();
        System.out.println(users.toString());
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();
        session.createNativeQuery("TRUNCATE TABLE users").executeUpdate();
        ta.commit();
        System.out.println("Table cleaned");
        session.close();

    }
}