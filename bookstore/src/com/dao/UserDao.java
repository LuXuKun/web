package com.dao;

import com.entity.User;

import java.util.List;

/**
 * Created by luxu on 2017/8/8.
 */
public interface UserDao {
    public boolean addUser(User user);
    public User checkUser(String email,String password);
    public List<User> getAllUser();
    public User getUserById(int id);
    public void updateUser(User user);
    public void deleteUser(User user);
    public List<User> getUserByName(String name);
    public List<User> getUserByEmail(String email);
}
