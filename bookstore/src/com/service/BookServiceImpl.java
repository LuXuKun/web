package com.service;

import com.dao.BookDao;
import com.entity.Book;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by luxu on 2017/8/12.
 */
public class BookServiceImpl implements BookService{
    private BookDao bookDao;

    public BookDao getBookDao() {
        return bookDao;
    }

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> getAllBooks()
    {
        return bookDao.getAllBooks();
    }

    public Book getBookById(int id)
    {
        return bookDao.getBookById(id);
    }

    public List<Book> getBookByTitle(String title)
    {
        return bookDao.getBookByTitle(title);
    }

    public List<Book> getBookByCategory(String category)
    {
        return bookDao.getBookByCategory(category);
    }

    public List<Book> getBookByID(int bookid)
    {
        return bookDao.getBookByID(bookid);
    }

    public void addBook(Book book)
    {
        bookDao.addBook(book);
    }

    public void updateBook(Book book)
    {
        bookDao.updateBook(book);
    }

    public void deleteBook(Book book)
    {
        bookDao.deleteBook(book);
    }
}
