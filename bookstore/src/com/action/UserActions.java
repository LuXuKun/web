package com.action;

import com.entity.MyOrder;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by luxu on 2017/8/12.
 */
public class UserActions extends ActionSupport {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String password;
    private String email;
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

    public String addToCart() throws IOException
    {
        HttpServletResponse response= ServletActionContext.getResponse();
        HttpServletRequest request=ServletActionContext.getRequest();
        int bookid =  Integer.parseInt(request.getParameter("id"));
        Map<String, Object> session = ActionContext.getContext().getSession();
        Map<Integer,Integer> cart= (Map<Integer, Integer>) session.get("cart");
        if(cart.containsKey(bookid))
        {
            cart.put(bookid, cart.get(bookid)+1);
        }
        else
        {
            cart.put(bookid,1);
        }
        JSONObject results = new JSONObject();
        results.put("success", true);
        response.getWriter().print(results.toString());
        return null;
    }

    public String deleteFromCart() throws IOException
    {
        HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();
        int id =  Integer.parseInt(request.getParameter("id"));
        Map<String, Object> session = ActionContext.getContext().getSession();
        @SuppressWarnings("unchecked")
        Map<Integer,Integer> cart= (Map<Integer, Integer>) session.get("cart");
        if(cart.containsKey(id))
        {
            cart.remove(id);
            JSONObject results = new JSONObject();
            results.put("success", true);
            response.getWriter().print(results.toString());
        }
        return null;
    }

    public String getAllUser() throws IOException
    {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source,String name,Object value) {
                if(name.equals("myorders")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        HttpServletResponse response=ServletActionContext.getResponse();
        List<User> userlist=userService.getAllUser();
        String result= JSONArray.fromObject(userlist,config).toString();
        response.getWriter().print(result);
        return null;
    }

    public String addUser() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        userService.addUser(user);
        JSONObject results = new JSONObject();
        results.put("success", true);
        response.getWriter().print(results.toString());
        return null;
    }

    public String updateUser() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        User user=userService.getUserById(id);
        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        userService.updateUser(user);
        JSONObject results = new JSONObject();
        results.put("success", true);
        response.getWriter().print(results.toString());

        return null;
    }

    public String deleteUser() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        User user=userService.getUserById(id);
        userService.deleteUser(user);
        JSONObject results = new JSONObject();
        results.accumulate("success", true);
        response.getWriter().print(results.toString());

        return null;
    }

    public String getUserByName() throws IOException
    {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source,String name,Object value) {
                if(name.equals("myorders")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        HttpServletResponse response=ServletActionContext.getResponse();
        List<User> userlist=userService.getUserByName(name);
        String result= JSONArray.fromObject(userlist,config).toString();
        response.getWriter().print(result);
        return null;
    }

    public String getUserByEmail() throws IOException
    {
        JsonConfig config = new JsonConfig();
        config.setJsonPropertyFilter(new PropertyFilter(){
            public boolean apply(Object source,String name,Object value) {
                if(name.equals("myorders")) {
                    return true;
                } else {
                    return false;
                }
            }
        });
        HttpServletResponse response=ServletActionContext.getResponse();
        List<User> userlist=userService.getUserByEmail(email);
        String result= JSONArray.fromObject(userlist,config).toString();
        response.getWriter().print(result);
        return null;
    }

    public String getUserOrders() throws IOException
    {
        HttpServletResponse response=ServletActionContext.getResponse();
        Map<String, Object> session = ActionContext.getContext().getSession();
        User user=(User)session.get("user");
        JSONArray orders = new JSONArray();
        Set<MyOrder> orderset=user.getMyorders();
        Iterator<MyOrder> rs = orderset.iterator();
        while (rs.hasNext()) {
            JSONObject result = new JSONObject();
            MyOrder tmp=rs.next();
            result.put("title", tmp.getBook().getTitle());
            result.put("amount", tmp.getAmount());
            result.put("year", tmp.getYear());
            result.put("month", tmp.getMonth());
            result.put("day", tmp.getDay());
            orders.add(result);
        }
        response.getWriter().print(orders.toString());
        return null;
    }
}
