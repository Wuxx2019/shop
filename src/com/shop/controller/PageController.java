package com.shop.controller;

import com.shop.utils.ConstantUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ProjectName：shop
 * @ClassName：PageController
 * @Description：页面跳转控制
 * @Author：wuxingxing
 * @Date：2019/10/17 15:57
 */
@WebServlet(name = "admin",urlPatterns = "/admin.do")
public class PageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 默认跳转后台主页，如果跳转其他页面需要自行传参数，值为要跳转的路径即可
         * 参数名称：pageParam
         * 参数值：路径
         */
        String page=  req.getParameter("page");
        if(null != page && !"".equals(page)){
            req.getRequestDispatcher(page).forward(req, resp);
            return;
        }
        req.getRequestDispatcher(ConstantUtil.ADMIN_PAGE_INDEX).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}