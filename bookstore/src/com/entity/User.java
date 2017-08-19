package com.entity;

import java.util.Set;

/**
 * Created by luxu on 2017/8/8.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
