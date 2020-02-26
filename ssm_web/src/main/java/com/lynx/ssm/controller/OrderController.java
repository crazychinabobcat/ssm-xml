package com.lynx.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.lynx.ssm.domain.Order;
import com.lynx.ssm.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    //分页查询全部订单
    @RequestMapping("/findAll")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "size",required = true,defaultValue = "4")Integer size)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(orderList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    //删除订单
    @RequestMapping(value = "deleteOrder.do",method = {RequestMethod.POST})
    @ResponseBody
    public String deleteProduct(String[] orderIds)throws Exception{
        orderService.deleteOrder(orderIds);
        return "200";
    }

    //根据id查询订单信息
    @RequestMapping("findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String orderid)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Order order = orderService.findByid(orderid);
        modelAndView.addObject("orders",order);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
