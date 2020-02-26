package com.lynx.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.lynx.ssm.dao.IProductDao;
import com.lynx.ssm.domain.Product;
import com.lynx.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductDao productDao;


    @Override
    public List<Product> findAll(Integer page,Integer size) throws Exception {
        //参数pageNum是页码值，参数pageSize是代表每页显示条数
        PageHelper.startPage(page,size);
        return productDao.findAll();
    }


    //增加商品
    @Override
    public void saveProduct(Product product)throws Exception {
       productDao.saveProduct(product);
    }

    //根据id删除商品
    @Override
    public void deleteProduct(String[] proudctIds)throws Exception {
        for (String productsId:proudctIds)
        productDao.deleteProduct(productsId);
    }

    //修改商品状态
    @Override
    public void updateProduct(String[] productIds)throws Exception {
        for (String productsId:productIds){
            productDao.updateProduct(productsId);
        }
    }

        //根据id查询商品信息
    @Override
    public Product findById(String productid)throws Exception {
        Product product =  productDao.findById(productid);
        return product;
    }
}
