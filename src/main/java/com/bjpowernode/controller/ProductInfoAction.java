package com.bjpowernode.controller;

import com.bjpowernode.entity.Page;
import com.bjpowernode.pojo.ProductInfo;
import com.bjpowernode.service.ProductInfoService;
import com.bjpowernode.utils.FileNameUtil;
import com.github.pagehelper.PageInfo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wjs
 * @create 2022-02-22 11:20
 */
@Controller
@RequestMapping("/prod")
public class ProductInfoAction {
    @Autowired
    private ProductInfoService productInfoService;
    String toDateBaseName = "";

    //显示所有商品不分页
    @RequestMapping("/getAll")
    public String getAll(HttpServletRequest request) {
        System.out.println("进入服务器");
        List<ProductInfo> all = productInfoService.getAll();
        request.setAttribute("list", all);
        return "product";
    }

    //    显示第一页所有商品
//     得到第一页的数据
    @RequestMapping("split")
    public String split(HttpServletRequest request) {
        //    得到第一页的数据
        PageInfo Info = productInfoService.splitPage(1, Page.PAGE_SIZE);
        request.setAttribute("info", Info);
        //request.getSession().setAttribute("typeList",);
        return "product";
    }

    /**
     * 利用ajax请求得到点击哪里显示几条数据的结果
     *
     * @param page
     * @param session
     */
    @ResponseBody
    @RequestMapping("/ajaxsplit")
    public void ajaxsplit(int page, HttpSession session) {
        //    取得当前page参数的页面的数据
        PageInfo splitPage = productInfoService.splitPage(page, Page.PAGE_SIZE);
        session.setAttribute("info", splitPage);
    }

    /**
     * 利用ajax进行图片上传回显
     */
    @RequestMapping("/ajaxImg")
    @ResponseBody
    public Object fileuploadImages(MultipartFile pimage, HttpServletRequest request) {
        //    1.接受来自客户端的图片名称
        String filename = pimage.getOriginalFilename();
        //    2.利用uuid对图片名称进行替换
        String uploadName = FileNameUtil.getUUIDFileName() + FileNameUtil.getFileType(filename);
        toDateBaseName = FileNameUtil.getFileType(filename);
        System.out.println("上传文件名----------------->" + uploadName);
        //3.获取真实上传路径
        //String realPath = request.getSession().getServletContext().getRealPath(File.separator);
        String realPath = request.getServletContext().getRealPath("/image_big");
        System.out.println("realPath = " + realPath);
        String path = realPath + File.separator + uploadName;
        System.out.println("上传路径是-------------------->" + path);
        try {
            pimage.transferTo(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return uploadName;
        Map<String, String> map = new HashMap<>();
        map.put("imgurl1", uploadName);
        //返回客户端Json对象，封装图片的路径，为了在页面实现立即回显
        return map;

        //JSONObject jsonObject = new JSONObject();
        //jsonObject.put("imgurl", uploadName);
        //System.out.println("jsonObject = " + jsonObject);
        //System.out.println(jsonObject.toString()+"jsonObject.toString()");
        //return jsonObject.toString();
    }

    @RequestMapping("/save")
    public String saveProduct(ProductInfo productInfo, HttpServletRequest request) {
        productInfo.setpDate(new Date());
        System.out.println("toDateBaseName = " + toDateBaseName);
        productInfo.setpImage(toDateBaseName);
        int count = productInfoService.saveProduct(productInfo);
        if (count > 0) {
            request.setAttribute("msg", "增加成功");
        } else {
            request.setAttribute("msg", "增加失败");
        }
        return "forward:/prod/ajaxsplit";
    }
}
