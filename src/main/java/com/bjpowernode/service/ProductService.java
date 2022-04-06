package com.bjpowernode.service;

import com.bjpowernode.pojo.ProductType;

import java.util.List;

/**
 * @author wjs
 * @create 2022-02-24 18:24
 */
public interface ProductService {
    /**
     * 从数据库中查询所有商品类别
     * @return
     */
    List<ProductType> findAll();
}
