package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

/**
 * Created by luxu on 2017/8/8.
 */
public class SignUp extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String password;
    private String email;
    private String result;
    private UserService userService;

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

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String addUser()
    {
        User user=new User();
        user.setName(name);
        user.setPassword(password);
        user.setId(id);
        user.setEmail(email);

        if(userService.addUser(user))
        {
            return SUCCESS;
        }
        else
        {
            return ERROR;
        }
    }
}
