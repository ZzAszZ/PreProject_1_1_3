package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static jm.task.core.jdbc.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {


    public UserDaoHibernateImpl() {

    }



    @Override
    public void createUsersTable() {

        Session session =  getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();

        try (session) {
            session.createNativeQuery("CREATE TABLE IF NOT EXISTS leanbase.users" +
                    " (id mediumint not null auto_increment, name VARCHAR(45), " +
                    "lastname VARCHAR(45), " +
                    "age tinyint, " +
                    "PRIMARY KEY (id))").executeUpdate();
            session.getTransaction().commit();
            System.out.println("Table create!");

        } catch (RuntimeException e) {
            if (ta != null) ta.rollback();
            System.out.println("Table not created");
        }



    }

    @Override
    public void dropUsersTable() {

        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();

        try(session) {
            session.createNativeQuery("DROP TABLE IF EXISTS leanbase.users").executeUpdate();
            ta.commit();
            System.out.println("Table deleted!");

        } catch (RuntimeException e){
            System.out.println("Table not deleted!");
            if(ta != null) ta.rollback();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();

        try(session) {
            session.save(new User(name, lastName, age));
            ta.commit();
            System.out.println("User saved!");
            session.close();
        }catch (RuntimeException e){
            System.out.println("User not saved!");
            if (ta != null) ta.rollback();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();
        try(session) {
            session.delete(session.get(User.class, id));
            ta.commit();
            System.out.println("User " + id + " deleted!");
        } catch (RuntimeException e) {
            System.out.println("User not deleted!");
            if (ta != null) ta.rollback();
    }


    }

    @Override
    public List<User> getAllUsers() {
        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();

        try(session) {
            List<User> users = (List<User>) getSessionFactory().openSession().createQuery("From User").list();
            System.out.println(users.toString());
            ta.commit();
            System.out.println("Users Table:");
            return users;
        } catch (RuntimeException e){
            System.out.println("Users Table Error!");
            if (ta != null) ta.rollback();
            return null;
        }
    }

    @Override
    public void cleanUsersTable() {

        Session session = getSessionFactory().openSession();
        Transaction ta = session.beginTransaction();
        try (session) {
            session.createNativeQuery("TRUNCATE TABLE leanbase.users").executeUpdate();
            ta.commit();
            System.out.println("Table cleaned!");

        }catch (RuntimeException e) {
            System.out.println("Table not clean");
            if(ta != null) ta.rollback();
        }

    }
}
