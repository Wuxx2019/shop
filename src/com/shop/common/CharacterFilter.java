package com.shop.common;

import com.shop.utils.ConstantUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ProjectName：shop
 * @ClassName：CharacterFilter
 * @Description：字符过滤器，防止中文乱码
 * @Author：wuxingxing
 * @Date：2019/10/14 16:18
 */
public class CharacterFilter implements Filter {
    /**字符集编码类型*/
    private String character;

    /**
     * Filter的初始化
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 读取web.xml中Filter配置的初始化参数
        character = filterConfig.getInitParameter(ConstantUtil.COMMON_STR_CHARACTER);
    }

    /**
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        // 读取初始化的参数character
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String requestURI=request.getRequestURI();
        if (requestURI.contains(ConstantUtil.LJ_COMMON_CSS) || requestURI.contains(ConstantUtil.LJ_COMMON_JS)){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            servletRequest.setCharacterEncoding(character);
            servletResponse.setCharacterEncoding(character);
            servletResponse.setContentType(ConstantUtil.CONTENT_TYPE_UTF8);
            // 放行，转到下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        }




    }

    /**
     * 在Filter销毁前，完毕某些资源的回收
     */
    @Override
    public void destroy() {

    }
}