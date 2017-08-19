package com.dao;

import com.entity.MyOrder;

import java.util.List;

/**
 * Created by luxu on 2017/8/17.
 */
public interface OrderDao {
    public void addOrder(MyOrder order);
    public List<MyOrder> getOrderByUB(int userid, int bookid);
    public List<MyOrder> getOrderByUBD(int userid, int bookid,int startdate,int enddate);
}
