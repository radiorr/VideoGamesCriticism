package com.radio.videogamescriticism.controller;


import com.radio.videogamescriticism.domain.VgcComment;
import com.radio.videogamescriticism.service.VgcCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class CommentController {
    int game_id = 0;
    @Autowired
    private VgcCommentService vgccommentservice;

    @ResponseBody
    @RequestMapping("/getCom01")
    public List<VgcComment> onegamecom(HttpServletRequest request, HttpServletResponse response) {
        game_id = 1;
        List<VgcComment> comment = vgccommentservice.getcomment(game_id);
        System.out.println("游戏评论加载");
        return comment;
    }
}
