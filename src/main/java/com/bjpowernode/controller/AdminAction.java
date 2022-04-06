package com.bjpowernode.controller;

import com.bjpowernode.pojo.Admin;
import com.bjpowernode.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wjs
 * @create 2022-02-11 11:46
 */
@Controller
@RequestMapping("/admin")
public class AdminAction {
//    所有的界面层，一定会有业务逻辑层的对象
    @Autowired
    private AdminService adminService;
//    实现登陆判断，并实现跳转
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        System.out.println("---login----进入了controller");
        Admin login = adminService.login(name, pwd);
        System.out.println(login);
        if(login!=null){
            //如果登陆成功跳转到主页
            request.setAttribute("admin",login);
            return "main";
        }else {
            request.setAttribute("errmsg","用户名或则密码错误!");
            return "login";
        }
    }
}
