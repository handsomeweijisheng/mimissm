package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.ProductTypeMapper;
import com.bjpowernode.pojo.ProductType;
import com.bjpowernode.pojo.ProductTypeExample;
import com.bjpowernode.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjs
 * @create 2022-02-24 18:27
 */
@Service
public class ProductServiceImpl implements ProductService {
    /**
     * 将此信息放入到监听器中进行操作
     */
    @Autowired
    private ProductTypeMapper productTypeMapper;
    @Override
    public List<ProductType> findAll() {

        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
