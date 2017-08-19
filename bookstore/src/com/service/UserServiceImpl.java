package com.service;

import com.dao.UserDao;
import com.entity.User;

import java.util.List;

/**
 * Created by luxu on 2017/8/8.
 */
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(User user) {
        // TODO Auto-generated method stub
        if (user == null)
        {
            return false;
        }

        if(user.getName()==null||user.getPassword()==null||user.getEmail()==null)
        {
            return false;
        }

        //TODO 判断name、password、email是否符合规范

        return userDao.addUser(user);
    }

    public User checkUser(String email,String password)
    {
        return userDao.checkUser(email,password);
    }

    public List<User> getAllUser()
    {
        return userDao.getAllUser();
    }

    public User getUserById(int id)
    {
        return userDao.getUserById(id);
    }

    public void updateUser(User user)
    {
        userDao.updateUser(user);
    }

    public void deleteUser(User user)
    {
        userDao.deleteUser(user);
    }

    public List<User> getUserByName(String name)
    {
        return userDao.getUserByName(name);
    }

    public List<User> getUserByEmail(String email)
    {
        return userDao.getUserByEmail(email);
    }

}
