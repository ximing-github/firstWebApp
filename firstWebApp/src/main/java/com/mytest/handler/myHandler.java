package com.mytest.handler;

import com.mytest.beans.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ClassName:myHandler
 * Package: com.mytest.handler
 * Description:
 *
 * @Date: 2021/5/21 12:34
 * @Author: 惜名
 */
public class myHandler implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return true;
    }
}
