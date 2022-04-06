package com.bjpowernode.service;

import com.bjpowernode.pojo.ProductInfo;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author wjs
 * @create 2022-02-22 11:16
 */
public interface ProductInfoService {
    //显示所有商品不分页
    List<ProductInfo> getAll();

    //    分页功能的实现
    PageInfo splitPage(int currentPage, int pageSize);
    //增加
    int saveProduct(ProductInfo productInfo);
}
