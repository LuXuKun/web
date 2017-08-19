package com.entity;

import java.util.Set;

/**
 * Created by luxu on 2017/8/10.
 */
public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private int price;
    private Set<MyOrder> myorders;

    public Set<MyOrder> getMyorders() {
        return myorders;
    }

    public void setMyorders(Set<MyOrder> myorders) {
        this.myorders = myorders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
