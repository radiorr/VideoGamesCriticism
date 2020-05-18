package com.radio.videogamescriticism.controller;

import com.radio.videogamescriticism.domain.VgcUser;
import com.radio.videogamescriticism.service.VgcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
    public int userLoginCheck(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("外部用户进入登录检查");
        String tnumber = request.getParameter("tnumber");
        String tpassword = request.getParameter("tpassword");
        System.out.println(tnumber);
        System.out.println(tpassword);
        VgcUser user = vgcUserService.checkOne(tnumber, tpassword);
        System.out.println(user);
        return checkuser(user, request, response, tnumber, tpassword);
    }


    // 注册验证
    @RequestMapping("/regcheck")
    @ResponseBody
    public int userRegCheck(HttpServletRequest request, HttpServletResponse response) {


        String rnumber = request.getParameter("rnumber");
        String rpassword = request.getParameter("rpassword");
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
        return checkuser(user, request, response, rnumber, rpassword);
    }

    @RequestMapping(value = "/loginout")
    public String loginout(HttpServletRequest request) {
        System.out.println("登出操作");

        HttpSession session = request.getSession();

        // 将用户信息从session中删除
        session.removeAttribute("userInfo");

        Object userInfo = session.getAttribute("userInfo");

        if (userInfo == null) {
            System.out.println("登出成功");
        } else {
            System.out.println("登出失败");
        }


        return "index";

    }

    @ResponseBody
    @RequestMapping("/getuser")
    public Object gameinfo(HttpServletRequest request, HttpServletResponse response) {
        Object session = request.getSession().getAttribute("userInfo");
        System.out.println("getuser用户是否已登录");
        System.out.println("getuser:" + session);
        return session;
    }

    public int checkuser(VgcUser user, HttpServletRequest request, HttpServletResponse response, String number, String password) {

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", number);
            session.setAttribute("password", password);
            Cookie usernameCookie = new Cookie("username", number);
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
            //将用户信息存放到session中
            request.getSession().setAttribute("userInfo", number);

            System.out.println("外部用户登录成功");
            System.out.println("username:" + number);
            System.out.println("password:" + password);

            return 1;
        } else {

            System.out.println("外部用户登录失败");
            return 0;
        }
    }


}
