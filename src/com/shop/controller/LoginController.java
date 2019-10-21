package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;
import com.shop.utils.ConstantUtil;
import com.shop.utils.Rcode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName：shop
 * @ClassName：LonginController
 * @Description：登录，登出等控制
 * 属性name描述Servlet的名字,可选;
 * 属性urlPatterns定义访问的URL,或者使用属性value定义访问的URL.(定义访问的URL是必选属性)
 * @Author：wuxingxing
 * @Date：2019/10/14 15:50
 */
@WebServlet(name = "login",urlPatterns = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("您号啊Q！！！！这是GET方法");
        //super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().write("您号啊Q！！！！这是POST方法");
        UserService userService = new UserServiceImpl();
        String userName=  req.getParameter(ConstantUtil.COMMON_STR_USER);
        String password= req.getParameter(ConstantUtil.COMMON_STR_PAS);
        String sysType= req.getParameter(ConstantUtil.COMMON_STR_SYS);
       String result = userService.login(userName,password);
        //使用request对象的getSession()获取session，如果session不存在则创建一个
        HttpSession session = req.getSession();
        //将用户名存入session中
        session.setAttribute(ConstantUtil.COMMON_STR_USER,userName);
        //用户含有模块权限存入session中
        session.setAttribute(ConstantUtil.COMMON_STR_SYS,sysType);
        //将返回的结果写到页面上
        resp.getWriter().write(JSON.toJSONString(new Rcode(result)));
    }
}