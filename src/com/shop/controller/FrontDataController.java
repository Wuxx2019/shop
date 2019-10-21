package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.common.page.Page;
import com.shop.entity.UserInfo;
import com.shop.service.UserService;
import com.shop.service.impl.UserServiceImpl;
import com.shop.utils.CommonUtil;
import com.shop.utils.ConstantUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：AdminController
 * @Description：后台所有数据接口
 * 后台接口必须参数
 * 属性名称：adminUrl
 * 值：要查询的方法
 * @Author：wuxingxing
 * @Date：2019/10/17 22:32
 */
@WebServlet(name = "front",urlPatterns = "/frontData.do")
public class FrontDataController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String,Object> params = CommonUtil.getParameterMap(req);

        Object frontData=  params.get(ConstantUtil.COMMON_URL_FRONT);
        if("goodList".equals(frontData)){
            UserService userService = new UserServiceImpl();
            Page<UserInfo> userInfoPage =  userService.queryPageList(params);
            resp.getWriter().write(JSON.toJSONString(userInfoPage));
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}