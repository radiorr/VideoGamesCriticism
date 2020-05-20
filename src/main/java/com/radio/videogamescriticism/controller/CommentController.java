package com.radio.videogamescriticism.controller;


import com.radio.videogamescriticism.domain.VgcComment;
import com.radio.videogamescriticism.service.VgcCommentService;
import com.radio.videogamescriticism.service.VgcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class CommentController {
    static int game_id = 0;
    @Autowired
    private VgcCommentService vgccommentservice;
    @Autowired
    private VgcUserService vgcuserService;


    @ResponseBody
    @RequestMapping("/getCom")
    public List<VgcComment> onegamecom01(HttpServletRequest request, HttpServletResponse response) {
        List<VgcComment> comment = vgccommentservice.getcomment(game_id);
        System.out.println("游戏评论加载");
        return comment;
    }

    @RequestMapping("/newCom")
    @ResponseBody
    public int newgamecom(HttpServletRequest request, HttpServletResponse response) {
        String game_id = request.getParameter("game_id");
        String username = request.getParameter("username");
        String commenttext = request.getParameter("commenttext");
        String user_id = vgcuserService.getuserid(username);
        if (user_id != null && commenttext != null && username != null && game_id != null) {
            vgccommentservice.insertcomment(user_id, game_id, commenttext);
            return 1;
        } else {
            return 0;
        }

    }

}
