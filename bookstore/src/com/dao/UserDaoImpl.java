package com.dao;

import com.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by luxu on 2017/8/8.
 */
public class UserDaoImpl implements UserDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public boolean addUser(User user)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        User user1=(User)session.createQuery("select u from User u where u.email = :email").setParameter("email",user.getEmail()).uniqueResult();
        if(user1!=null)
        {
            tmp.commit();
            session.close();
            return false;
        }
        session.save(user);
        tmp.commit();
        session.close();
        return true;
    }

    public User checkUser(String email,String password)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        User user1=(User)session.createQuery("select u from User u where u.email = :email and u.password=:password")
                .setParameter("email",email).setParameter("password",password).uniqueResult();
        tmp.commit();
        session.close();
        return user1;
    }

    public List<User> getAllUser()
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<User> userlist=session.createQuery("From User").list();
        tmp.commit();
        session.close();
        return userlist;
    }

    public User getUserById(int id)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        User user1=(User)session.createQuery("select u from User u where u.id = :id")
                .setParameter("id",id).uniqueResult();
        tmp.commit();
        session.close();
        return user1;
    }

    public void updateUser(User user)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        session.update(user);
        tmp.commit();
        session.close();
    }

    public void deleteUser(User user)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        session.delete(user);
        tmp.commit();
        session.close();
    }

    public List<User> getUserByName(String name)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<User> userlist=session.createQuery(" select u from User u where u.name=:name").setParameter("name",name).list();
        tmp.commit();
        session.close();
        return userlist;
    }

    public List<User> getUserByEmail(String email)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<User> userlist=session.createQuery(" select u from User u where u.email=:email").setParameter("email",email).list();
        tmp.commit();
        session.close();
        return userlist;
    }
}
