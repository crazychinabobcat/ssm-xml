package com.lynx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lynx.ssm.dao.IOrderDao;
import com.lynx.ssm.domain.Order;
import com.lynx.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private IOrderDao orderDao;
    //分页查询全部订单

    @Override
    public List<Order> findAll(Integer page, Integer size) throws Exception {
        PageHelper.startPage(page,size);
        return orderDao.findAll();
    }

    //删除订单
    @Override
    public void deleteOrder(String[] orderIds) throws Exception {
        for (String orders:orderIds){
            orderDao.deleteOrder(orders);
        }
    }

    //根据id订单查询
    @Override
    public Order findByid(String orderid) throws Exception {
        return orderDao.findByid(orderid);

    }
}
