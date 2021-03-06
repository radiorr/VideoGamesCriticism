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
    List<VgcGame> game;
    List<VgcGame> taggame;
    @RequestMapping("/")
    public String login(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("外部用户进入登录页");

        return "index";
    }

    @ResponseBody
    @RequestMapping("/gettagGame")
    public int taggameinfo(HttpServletRequest request, HttpServletResponse response) {
        String tag = request.getParameter("tag");
        taggame = vgcgameService.gettaggame(tag);
        return 1;
    }

    @ResponseBody
    @RequestMapping("/getAllGame")
    public List<VgcGame> gameinfo(HttpServletRequest request, HttpServletResponse response) {

        if (taggame == null) {
            System.out.println("游戏数据加载");
            game = vgcgameService.getAllinfo();
            return game;
        } else {
            System.out.println("游戏数据加载2");
            game = taggame;
            taggame = null;
            return game;
        }
        /*try {
            Thread.currentThread().sleep(1 * 1000);
        } catch (InterruptedException e) {
        }*/

    }
}