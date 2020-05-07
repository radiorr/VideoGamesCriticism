package com.radio.videogamescriticism.controller;

import com.radio.videogamescriticism.domain.VgcGame;
import com.radio.videogamescriticism.service.VgcGameService;
import com.radio.videogamescriticism.service.VgcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController{
    @Autowired
    private VgcUserService vgcuserService;
    @Autowired
    private VgcGameService vgcgameService;

    @RequestMapping("/index")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("外部用户进入登录页");

        return "index";
    }

    @ResponseBody
    @RequestMapping("/getAllGame")
    public List<VgcGame> gameinfo(HttpServletRequest request, HttpServletResponse response) {
        List<VgcGame> game = vgcgameService.getAllinfo();

        System.out.println("游戏数据加载");
        return game;
    }

}