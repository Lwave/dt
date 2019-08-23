package com.dt.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter的request："+servletRequest);
        //0.强制转换
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("utf-8");
        //1.获取资源请求路径
        String uri = request.getRequestURI();
        //2.判断是否包含登录相关的资源路径,要以排除 css/js/图片/验证码等资源
        if (uri.contains("/login.jsp") || uri.contains("/loginServlet")||uri.contains("/css/")||uri.contains("/js/")||uri.contains("/font/")||uri.contains("/checkCodeServlet")) {
            //包含，用户就是想登录，放行
            //放行
         filterChain.doFilter(servletRequest,servletResponse);
        }else{
            //不包含，需要验证用户是否登陆
            //从session获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null) {
                //登录了，放行
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                //没有登陆，跳转到登录页面
                request.setAttribute("login_msg","你尚未登录，请登录");
                request.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            }
        }


    }

    @Override
    public void destroy() {

    }
}
