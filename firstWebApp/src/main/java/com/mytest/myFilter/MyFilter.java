package com.mytest.myFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * ClassName:MyFilter
 * Package: com.mytest.myFilter
 * Description:
 *
 * @Date: 2021/5/24 17:29
 * @Author: 惜名
 */
public class MyFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String servletPath = request.getServletPath();
      // System.out.println(servletPath);
        if ("/jsp/index.jsp".equals(servletPath)|| ("/login".equals(servletPath)) || (session != null && session.getAttribute("username") != null)) {
            //System.out.println("未拦截");
            filterChain.doFilter(request,response);
        }else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
