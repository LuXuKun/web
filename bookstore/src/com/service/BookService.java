package com.service;

import com.entity.Book;

import java.util.List;

/**
 * Created by luxu on 2017/8/12.
 */
public interface BookService {
    public List<Book> getAllBooks();
    public Book getBookById(int id);
    public List<Book> getBookByTitle(String title);
    public List<Book> getBookByCategory(String category);
    public List<Book> getBookByID(int bookid);
    public void addBook(Book book);
    public void updateBook(Book book);
    public void deleteBook(Book book);
}
