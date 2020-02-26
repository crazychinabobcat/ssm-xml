package com.lynx.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.lynx.ssm.domain.Product;
import com.lynx.ssm.service.IProductService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    //分页查询全部商品
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1")Integer page,@RequestParam(name = "size",required = true,defaultValue = "4")Integer size) throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> list = productService.findAll(page,size);
        PageInfo pageInfo = new PageInfo(list);
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("product-page-list");
        return  mv;
    }



    //增加商品
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        product.setId(UUID.randomUUID().toString().replace("-", ""));
        productService.saveProduct(product);
        return "redirect:findAll.do";
    }



    //根据id删除商品
    @RequestMapping(value = "/deleteProduct.do",method = {RequestMethod.POST})
    @ResponseBody
    public String  deleteProduct(String[] proudctIds)throws Exception{
        productService.deleteProduct(proudctIds);
        return "200";
    }

    //修改商品状态
    @RequestMapping(value = "/updateProduct.do",method = {RequestMethod.POST})
    @ResponseBody
    public  String updateProduct(String[] productIds)throws Exception{
        productService.updateProduct(productIds);
        return "200";
    }

    //根据商品id编辑
    @RequestMapping(value = "/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String productid)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        Product product =  productService.findById(productid);
        modelAndView.addObject("productlist",product);
        modelAndView.setViewName("product-edit");
        return modelAndView;
    }



}
