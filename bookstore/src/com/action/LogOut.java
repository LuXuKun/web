package com.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.hibernate.Session;

import java.applet.AppletContext;
import java.util.Map;

/**
 * Created by luxu on 2017/8/12.
 */
public class LogOut extends ActionSupport{
    public String logOut()
    {
        Map<String,Object> session= ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
}
