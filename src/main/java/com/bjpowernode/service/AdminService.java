package com.bjpowernode.service;

import com.bjpowernode.pojo.Admin;

/**
 * @author wjs
 * @create 2022-02-11 11:15
 */
public interface AdminService {
//    完成登陆判断
    Admin login(String name, String pwd);
}
