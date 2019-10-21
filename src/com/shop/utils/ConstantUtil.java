package com.shop.utils;

/**
 * @ProjectName：shop
 * @ClassName：ConstantUtil
 * @Description：常量定义类
 * @Author：wuxingxing
 * @Date：2019/10/17 13:47
 */
public interface ConstantUtil {
    /**
     * CONTENT_TYPE字符编码
     */
    String CONTENT_TYPE_UTF8 = "text/html; charset=UTF-8";


    /**
     * LJ拦截的路径
     */
    String LJ_LOGIN_JSP = "/front/login.jsp";//登陆页面
    String LJ_SHOPCART_JSP = "shopcart.jsp";//购物车页面
    String LJ_COMMON_DO = ".do";//后台接口
    String LJ_COMMON_JS = ".js";//js请求
    String LJ_COMMON_CSS = ".css";//css请求

    /**
     * COMMON通用常量
     */
    String COMMON_STR_NULL = "";//空字符
    String COMMON_STR_USER = "userName";//用户名属性
    String COMMON_STR_PAS = "password";//用户名属性
    String COMMON_STR_SYS = "sysType";//系统类别
    String COMMON_STR_FRONT = "front";//用户名类别-前台
    String COMMON_STR_ADMIN = "admin";//用户名类别-后台
    String COMMON_URL_ADMIN = "adminData";//后台请求属性名称
    String COMMON_URL_FRONT = "frontData";//台请求属性名称
    String COMMON_URL_ADMIN_PAGE = "PAGE";//分页请求
    Boolean COMMON_BOO_TRUE = true;//布尔类型
    String COMMON_STR_CHARACTER = "character";//字符属性名称
    Integer COMMON_ZERO = 0;
    Integer COMMON_ONE = 1;
    /**
     * MGS信息提示
     */
    String MSG_LOGIN_USER = "用户名错误!";
    String MSG_LOGIN_PAS = "密码错误!";
    String MSG_LOGIN_SUCCESS = "SUCCESS";//登录成功


    /**
     * ADMIN后台页面路径
     */
    String ADMIN_STR_INDEX = "admin/index.jsp";
    String ADMIN_PAGE_INDEX = "/WEB-INF/admin/index.jsp";

    /**
     * QUERY分页查询
     */
    String QUERY_ORDER = "order";
    String QUERY_FIELD = "field";
    String QUERY_PAGE_SIZE = "limit";
    String QUERY_PAGE = "page";

}