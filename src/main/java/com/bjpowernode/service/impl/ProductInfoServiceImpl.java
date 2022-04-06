package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.ProductInfoMapper;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.pojo.ProductInfoExample;
import com.bjpowernode.service.ProductInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjs
 * @create 2022-02-22 11:56
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoMapper productInfoMapper;

    /**
     * 不分页全部显示
     *
     * @return
     */
    @Override
    public List<ProductInfo> getAll() {
        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    /**
     * 分页查询
     *
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo splitPage(int currentPage, int pageSize) {
        //分页插件使用PageHelper工具类完成分页设置
        PageHelper.startPage(currentPage, pageSize);
        //进行PageInfo的数据封装
        //进行有条件的查询操作，必须创建ProductInfoExample对象
        ProductInfoExample example = new ProductInfoExample();
        //设置排序，按主键降序排序
        example.setOrderByClause("p_id desc");
        //设置完排序后，取集合
        List<ProductInfo> list = productInfoMapper.selectByExample(example);
        //将查询到的集合封装到PageInfo对象中
        PageInfo<ProductInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    //增加操作
    @Override
    public int saveProduct(ProductInfo productInfo) {
        return productInfoMapper.insert(productInfo);
    }
}
