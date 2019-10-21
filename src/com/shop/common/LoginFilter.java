package com.shop.common;

import com.shop.utils.ConstantUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ProjectName：shop
 * @ClassName：LoginFilter
 * @Description：登录验证拦截器
 * @Author：wuxingxing
 * @Date：2019/10/14 17:03
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpSession session = request.getSession(ConstantUtil.COMMON_BOO_TRUE);
        //获取session内存入的用户名，用来判断该用户是否在线
        String loginName = (String) session.getAttribute(ConstantUtil.COMMON_STR_USER);
        String sysType = (String) session.getAttribute(ConstantUtil.COMMON_STR_SYS);
        String url=request.getRequestURI();
        //判断用户是否登陆
        if(loginName == null || ConstantUtil.COMMON_STR_NULL.equals(loginName)){
            /**
             * 判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转
             */
            if(null != url && (url.contains(ConstantUtil.LJ_SHOPCART_JSP)) && !ConstantUtil.COMMON_STR_ADMIN.equals(sysType)) {
                //购物车需要拦截
                response.sendRedirect(ConstantUtil.LJ_LOGIN_JSP);
                return ;
            }
            if(null != url  && (url.contains(ConstantUtil.LJ_COMMON_DO)) && !ConstantUtil.COMMON_STR_FRONT.equals(sysType)) {
                //后台的数据查询需要拦截
                response.sendRedirect(ConstantUtil.LJ_LOGIN_JSP);
                return ;
            }
        }

        //已通过验证，用户访问继续
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}