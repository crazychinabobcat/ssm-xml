package com.lynx.ssm.dao;

import com.lynx.ssm.domain.Order;

import java.util.List;

public interface IOrderDao {
    //分页查询全部
    List<Order> findAll()throws Exception;
    //删除订单
    void deleteOrder(String orders)throws Exception;
    //根据id查询订单
    Order findByid(String orderid)throws Exception;
}
