package com.action;

import com.entity.Book;
import com.entity.MyOrder;
import com.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.BookService;
import com.service.OrderService;
import com.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Created by luxu on 2017/8/17.
 */
public class OrderActions extends ActionSupport {
    private OrderService orderService;
    private BookService bookService;
    private UserService userService;

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    public String addToOrder()
    {
        Map<String, Object> session = ActionContext.getContext().getSession();
        User user=(User)session.get("user");
        @SuppressWarnings("unchecked")
        Map<Integer,Integer> cart= (Map<Integer, Integer>) session.get("cart");
        for (Map.Entry<Integer, Integer> entry : cart.entrySet())
        {
            Calendar cal = Calendar.getInstance();
            int bookid=entry.getKey();
            int amount=entry.getValue();
            int day = cal.get(Calendar.DATE);
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
            Book book=bookService.getBookById(bookid);
            MyOrder order_tmp=new MyOrder();
            order_tmp.setUser(user);
            order_tmp.setBook(book);
            order_tmp.setAmount(amount);
            order_tmp.setYear(year);
            order_tmp.setMonth(month);
            order_tmp.setDay(day);
            orderService.addOrder(order_tmp);
        }
        cart.clear();
        user=userService.getUserById(user.getId());
        session.put("cart", cart);
        session.put("user", user);
        return SUCCESS;
    }

    public String orderStatistic() throws IOException
    {
        HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response= ServletActionContext.getResponse();
        JSONArray orders = new JSONArray();
        int startdate;
        int enddate;
        int userid;
        int bookid;
        try{
            userid=Integer.parseInt(request.getParameter("userid").toString());
        }
        catch(Exception e){
            userid=-1;
        }
        try{
            bookid=Integer.parseInt(request.getParameter("bookid").toString());
        }
        catch(Exception e){
            bookid=-1;
        }
        try{
            int year1=Integer.parseInt(request.getParameter("startyear").toString());
            int month1=Integer.parseInt(request.getParameter("startmonth").toString());
            int day1=Integer.parseInt(request.getParameter("startday").toString());
            int year2=Integer.parseInt(request.getParameter("endyear").toString());
            int month2=Integer.parseInt(request.getParameter("endmonth").toString());
            int day2=Integer.parseInt(request.getParameter("endday").toString());
            startdate=year1*10000+month1*100+day1;
            enddate=year2*10000+month2*100+day2;
        }
        catch(Exception e){
            startdate=-1;
            enddate=-1;
        }

        List<MyOrder> orderlist=new ArrayList<>();
        if(startdate<0)
        {
            orderlist=orderService.getOrderByUB(userid,bookid);
        }
        else
        {
            orderlist=orderService.getOrderByUBD(userid,bookid,startdate,enddate);
        }

        Iterator<MyOrder> rs = orderlist.iterator();
        while (rs.hasNext()) {
            JSONObject result = new JSONObject();
            MyOrder tmp=rs.next();
            result.put("orderid", tmp.getId());
            result.put("userid", tmp.getUser().getId());
            result.put("bookid", tmp.getBook().getId());
            result.put("price", tmp.getBook().getPrice());
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
