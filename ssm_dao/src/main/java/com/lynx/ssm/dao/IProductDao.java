package com.lynx.ssm.dao;

import com.lynx.ssm.domain.Product;

import java.util.List;

public interface IProductDao {
    //分页查询全部商品
    List<Product> findAll()throws Exception;
    //增加新商品
    void saveProduct(Product product)throws Exception;
    //根据id删除商品
    void deleteProduct(String productsId)throws Exception;
    //修改商品状态
    void updateProduct(String productsId)throws Exception;
    //根据商品id查询商品信息
    Product findById(String productid)throws Exception;
}
