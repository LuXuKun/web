package com.dao;

import com.entity.MyOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luxu on 2017/8/17.
 */
public class OrderDaoImpl implements OrderDao{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addOrder(MyOrder order)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        session.save(order);
        tmp.commit();
        session.close();
    }

    public List<MyOrder> getOrderByUB(int userid, int bookid)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<MyOrder> orderList=new ArrayList<>();
        if(userid<0)
        {
            if(bookid<0)
            {
                orderList=session.createQuery(" select o from MyOrder o").list();
            }
            else
            {
                orderList=session.createQuery(" select o from MyOrder o where o.book.id=:bookid")
                        .setParameter("bookid",bookid).list();
            }
        }
        else
        {
            if(bookid<0)
            {
                orderList=session.createQuery(" select o from MyOrder o where o.user.id=:userid")
                        .setParameter("userid",userid).list();
            }
            else
            {
                orderList=session.createQuery(" select o from MyOrder o where o.user.id=:userid and o.book.id=:bookid")
                        .setParameter("userid",userid).setParameter("bookid",bookid).list();
            }
        }
        tmp.commit();
        session.close();
        return orderList;
    }

    public List<MyOrder> getOrderByUBD(int userid, int bookid,int startdate,int enddate)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<MyOrder> orderList=new ArrayList<>();
        if(userid<0)
        {
            if(bookid<0)
            {
                orderList=session.createQuery(" select o from MyOrder o where " +
                        "((o.year*10000+o.month*100+o.day) between :startdate and :enddate)")
                        .setParameter("startdate",startdate).setParameter("enddate",enddate).list();
            }
            else
            {
                orderList=session.createQuery(" select o from MyOrder o where o.book.id=:bookid " +
                        "and ((o.year*10000+o.month*100+o.day) between :startdate and :enddate)")
                        .setParameter("startdate",startdate).setParameter("enddate",enddate)
                        .setParameter("bookid",bookid).list();
            }
        }
        else
        {
            if(bookid<0)
            {
                orderList=session.createQuery(" select o from MyOrder o where o.user.id=:userid "+
                        "and ((o.year*10000+o.month*100+o.day) between :startdate and :enddate)")
                        .setParameter("startdate",startdate).setParameter("enddate",enddate)
                        .setParameter("userid",userid).list();
            }
            else
            {
                orderList=session.createQuery(" select o from MyOrder o where o.user.id=:userid and o.book.id=:bookid "+
                        "and ((o.year*10000+o.month*100+o.day) between :startdate and :enddate)")
                        .setParameter("startdate",startdate).setParameter("enddate",enddate)
                        .setParameter("userid",userid).setParameter("bookid",bookid).list();
            }
        }
        tmp.commit();
        session.close();
        return orderList;
    }
}
