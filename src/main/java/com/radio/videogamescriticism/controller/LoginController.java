package com.radio.videogamescriticism.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.radio.videogamescriticism.domain.VgcUser;

import com.radio.videogamescriticism.service.VgcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
    @Autowired
    private VgcUserService vgcUserService;

    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("外部用户进入登录页");

        return "login";
    }

    // 登录验证
    @RequestMapping("/usercheck")
    @ResponseBody
    public int userLoginCheck(String param, HttpServletRequest request, HttpServletResponse response, Model model) {
        System.out.println("外部用户进入登录检查");
        String tnumber = request.getParameter("username");
        String tpassword = request.getParameter("tpassword");
        VgcUser user = vgcUserService.checkOne(tnumber, tpassword);
        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("username", tnumber);
            session.setAttribute("password", tpassword);
            System.out.println("外部用户登录");

            Cookie usernameCookie = new Cookie("username", tnumber);
            System.out.println("usernameCookie:" + usernameCookie);
            usernameCookie.setMaxAge(7 * 60 * 60);
            usernameCookie.setPath("/");
            response.addCookie(usernameCookie);

            Cookie[] cookies = request.getCookies();
            System.out.println("外部的SessionId:" + session.getId());
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("Cookie里边的SessionId：" + session.getId());
                    cookie.setValue(session.getId());
                    cookie.setPath("/");
                    cookie.setMaxAge(7 * 60 * 60);
                    response.addCookie(cookie);
                }
            }
            System.out.println("外部用户登录成功");
            System.out.println("username:" + tnumber);
            System.out.println("password:" + tpassword);
            return 1;
        } else {
            System.out.println("外部用户登录失败");
            return 0;
        }
    }


    // 注册验证
    @RequestMapping(value = "/regcheck")
    @ResponseBody
    public int userRegCheck(String param, HttpServletRequest request, HttpServletResponse response, Model model) {


        String rnumber = request.getParameter("username");
        String rpassword = request.getParameter("password");
        String nickname = request.getParameter("nickname");
        System.out.println("外部注册用户："+nickname+"进入注册");
        System.out.println("username:"+rnumber);
        System.out.println("password:"+rpassword);

        VgcUser cherename = vgcUserService.renamecheck(rnumber);
        if (cherename !=null){
            System.out.println("重名");
            return 0;
        }
        vgcUserService.insert(rnumber, rpassword, nickname);
        System.out.println("外部注册用户："+nickname+"注册成功");
        VgcUser user = vgcUserService.checkOne(rnumber, rpassword);
        System.out.println("外部注册用户："+nickname+"登录检查");
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", rnumber);
            session.setAttribute("password", rpassword);
            Cookie usernameCookie = new Cookie("username", rnumber);
            System.out.println("usernameCookie:" + usernameCookie);
            usernameCookie.setMaxAge(7 * 60 * 60);
            usernameCookie.setPath("/");
            response.addCookie(usernameCookie);

            Cookie[] cookies = request.getCookies();
            System.out.println("外部的SessionId:" + session.getId());
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("JSESSIONID")) {
                    System.out.println("Cookie里边的SessionId：" + session.getId());
                    cookie.setValue(session.getId());
                    cookie.setPath("/");
                    cookie.setMaxAge(7 * 60 * 60);
                    response.addCookie(cookie);
                }
            }
            System.out.println("外部用户登录成功");
            System.out.println("username:" + rnumber);
            System.out.println("password:" + rpassword);

            return 1;
        } else {

            System.out.println("外部用户登录失败");
            return 0;
        }

    }

}
