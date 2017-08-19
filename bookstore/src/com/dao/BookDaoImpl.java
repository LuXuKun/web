package com.dao;

import com.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Created by luxu on 2017/8/12.
 */
public class BookDaoImpl implements BookDao {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Book> getAllBooks()
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<Book> booklist=session.createQuery("From Book").list();
        tmp.commit();
        session.close();
        return booklist;
    }

    public Book getBookById(int id)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        Book book=(Book)session.createQuery("select b from Book b where b.id=:id").setParameter("id",id).uniqueResult();
        tmp.commit();
        session.close();
        return book;
    }

    public List<Book> getBookByTitle(String title)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<Book> booklist=session.createQuery("select b from Book b where b.title=:title").setParameter("title",title).list();
        tmp.commit();
        session.close();
        return booklist;
    }

    public List<Book> getBookByCategory(String category)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<Book> booklist=session.createQuery("select b from Book b where b.category=:category").setParameter("category",category).list();
        tmp.commit();
        session.close();
        return booklist;
    }

    public List<Book> getBookByID(int bookid)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        List<Book> booklist=session.createQuery("select b from Book b where b.id=:bookid").setParameter("bookid",bookid).list();
        tmp.commit();
        session.close();
        return booklist;
    }

    public void addBook(Book book)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        session.save(book);
        tmp.commit();
        session.close();
    }

    public void updateBook(Book book)
    {
        Session session1 = sessionFactory.openSession();
        Transaction tmp1 = session1.beginTransaction();
        session1.update(book);
        tmp1.commit();
        session1.close();
    }

    public void deleteBook(Book book)
    {
        Session session = sessionFactory.openSession();
        Transaction tmp = session.beginTransaction();
        session.delete(book);
        tmp.commit();
        session.close();
    }
}
