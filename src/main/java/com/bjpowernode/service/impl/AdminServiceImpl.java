package com.bjpowernode.service.impl;

import com.bjpowernode.mapper.AdminMapper;
import com.bjpowernode.pojo.Admin;
import com.bjpowernode.pojo.AdminExample;
import com.bjpowernode.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wjs
 * @create 2022-02-11 11:17
 */
@Service
public class AdminServiceImpl implements AdminService {
    //在业务逻辑层中一定会有数据访问层的对象
    @Autowired
     private AdminMapper adminMapper;
    //根据传入的用户或到DB中查询相应用户对象
    //如果有条件，一定创建AdminExample对象
    /**
     * 如何添加条件
     * select * from admin where a_name='admin'
     */
    @Override
    public Admin login(String name, String pwd) {
        System.out.println("---login--进入了service");
        //添加用户名a_name条件
        AdminExample example=new AdminExample();
        example.createCriteria().andANameEqualTo(name);
       List<Admin> list=adminMapper.selectByExample(example);
        System.out.println(list+"list");
       if(list!=null&&list.size()>0){
           System.out.println("wjs");
           Admin admin=list.get(0);
           //System.out.println(admin);
           //如果查询到用户对象，再进行密码的对比,注意密码是密文
           if(admin.getaPass().equals(pwd)){
               return admin;
           }
       }
        return null;
    }
}
