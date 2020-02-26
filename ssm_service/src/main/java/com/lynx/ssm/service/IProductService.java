package com.lynx.ssm.service;

import com.lynx.ssm.domain.Product;

import java.util.List;

public interface IProductService {
    //分页查询全部
    List<Product> findAll(Integer page,Integer size)throws Exception;
    //增加商品
    void saveProduct(Product product)throws Exception;
    //根据id删除商品
    void deleteProduct(String[] proudctIds)throws Exception;
    //修改商品状态
    void updateProduct(String[] productIds)throws Exception;
    //根据id查询商品
    Product findById(String productid)throws Exception;
}
