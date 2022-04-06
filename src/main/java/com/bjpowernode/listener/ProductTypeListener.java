package com.bjpowernode.listener;

import com.bjpowernode.pojo.ProductType;
import com.bjpowernode.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/*
 *
 * @author wjs
 * @create 2022-02-24 18:29

 */

public class ProductTypeListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //    从spring中取出ProductTypeServiceImpl对象
        System.out.println("begin to listener");
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_service.xml");
        ProductService productService = (ProductService) context.getBean("productServiceImpl");
        List<ProductType> typeList = productService.findAll();
        //    放入全局应用作用域中，供新增页面，修改页面，前台查询功能提供全部商品类别集合
        servletContextEvent.getServletContext().setAttribute("typeList", typeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
