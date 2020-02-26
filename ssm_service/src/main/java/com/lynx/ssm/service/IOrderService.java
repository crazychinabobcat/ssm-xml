package com.lynx.ssm.service;

import com.lynx.ssm.domain.Order;

import java.util.List;

public interface IOrderService {
    //分页查询全部订单
    List<Order> findAll(Integer page, Integer size)throws Exception;
    //删除订单
    void deleteOrder(String[] orderIds)throws Exception;
    //根据id查询订单
    Order findByid(String orderid)throws Exception;
}
