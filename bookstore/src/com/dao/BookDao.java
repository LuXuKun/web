package com.dao;

import com.entity.Book;

import java.util.List;

/**
 * Created by luxu on 2017/8/10.
 */
public interface BookDao {
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public List<Book> getBookByTitle(String title);
    public List<Book> getBookByCategory(String category);
    public List<Book> getBookByID(int bookid);
    public void addBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(Book book);
}
