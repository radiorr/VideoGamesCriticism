package com.radio.videogamescriticism.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author radior
 * @create 2020-05-12 21:31
 * @desc 登录状态拦截器
 **/

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("==========登录状态拦截==========");

        HttpSession session = request.getSession();
        System.out.println("sessionId为：" + session.getId());

        // 获取用户信息，如果没有用户信息直接返回提示信息
        Object userInfo = session.getAttribute("userInfo");
        if (userInfo == null) {

            System.out.println("没有登录");
            //直接重定向到登录页面
            //response.sendRedirect(request.getContextPath()+"/login");

            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("<script>window.alert('对不起，请登录！')</script>");
            response.getWriter().write("<script>window.location ='/login'</script>");
            return false;
        } else {
            System.out.println("已经登录过，用户信息为：" + session.getAttribute("userInfo"));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

