//package com.bjpowernode.upload;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.Part;
//import java.io.IOException;
//
///**
// * @author wjs
// * @create 2022-02-28 19:32
// */
//@WebServlet("/fileUpload.do")
//public class UploadServlet extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
//        //    1.接受参数
//        String name = request.getParameter("uname");
//        //   2.文件类型的数据 这就是文件
//        Part part = request.getPart("upFile");
//        //    3.part得到的就是文件
//        //    得到文件的名字
//        String keyName = part.getName();//key的名字 upFile
//        String fileName = part.getSubmittedFileName();//表单提交时 文件的名字
//        System.out.println("key" + keyName);
//        System.out.println("文件的名字" + fileName);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        doGet(req, resp);
//    }
//}
