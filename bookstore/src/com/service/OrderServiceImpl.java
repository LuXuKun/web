package com.service;

import com.dao.OrderDao;
import com.entity.MyOrder;

import java.util.List;

/**
 * Created by luxu on 2017/8/17.
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    public void addOrder(MyOrder order)
    {
        orderDao.addOrder(order);
    }

    public List<MyOrder> getOrderByUB(int userid, int bookid)
    {
        return orderDao.getOrderByUB(userid,bookid);
    }

    public List<MyOrder> getOrderByUBD(int userid, int bookid,int startdate,int enddate)
    {
        return orderDao.getOrderByUBD(userid,bookid,startdate,enddate);
    }

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
