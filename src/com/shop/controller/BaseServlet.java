package com.shop.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet("/BaseServlet")
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String methodName = request.getParameter("method");
        String name = (String)request.getAttribute("method");
        if(null!=methodName){
            //判断对象是哪一个servlet
            try {
                Method method = this.getClass().getMethod(methodName,HttpServletRequest.class,HttpServletResponse.class);
                method.invoke(this,request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //判断对象是哪一个servlet
            try {
                Method method = this.getClass().getMethod(name,HttpServletRequest.class,HttpServletResponse.class);
                method.invoke(this,request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}

