package com.action;

import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by luxu on 2017/8/9.
 */
public class LogIn  extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private int id;
    private String email;
    private String password;
    private String result;
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String checkUser()
    {
        User user=userService.checkUser(email,password);
        if(user==null)
        {
            return ERROR;
        }

        Map<String,Object>session = ActionContext.getContext().getSession();
        Map<Integer,Integer>cart=new HashMap<Integer,Integer>();
        session.put("user",user);
        session.put("cart",cart);

        if(user.getId()==1)
        {
            return "admin";
        }
        return "user";
    }
}
