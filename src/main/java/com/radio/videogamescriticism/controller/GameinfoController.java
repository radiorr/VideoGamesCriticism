package com.radio.videogamescriticism.controller;

import com.radio.videogamescriticism.domain.VgcGame;
import com.radio.videogamescriticism.service.VgcGameService;
import com.radio.videogamescriticism.service.VgcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class GameinfoController{
    @Autowired
    private VgcUserService vgcuserService;
    int game_id = 0;
    @Autowired
    private VgcGameService vgcgameService;

    @RequestMapping("/1")
    public String gameinfo01(Model model) {
        game_id = 1;
        CommentController.game_id = 1;
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setConum(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);

        return "gameinfo";
    }

    @RequestMapping("/2")
    public String gameinfo02(Model model) {
        game_id = 2;
        CommentController.game_id = 2;
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setConum(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);
        return "gameinfo";
    }

    @RequestMapping("/3")
    public String gameinfo03(Model model) {
        game_id = 3;
        CommentController.game_id = 3;
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setConum(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);
        return "gameinfo";
    }

    @RequestMapping("/4")
    public String gameinfo04(Model model) {
        game_id = 4;
        CommentController.game_id = 4;
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setConum(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);
        return "gameinfo";
    }

    @RequestMapping("/5")
    public String gameinfo05(Model model) {
        game_id = 5;
        CommentController.game_id = 5;
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setConum(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);
        return "gameinfo";
    }

    @RequestMapping("/6")
    public String gameinfo06(Model model) {
        game_id = 6;
        CommentController.game_id = 6;
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setConum(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);
        return "gameinfo";
    }

    @RequestMapping("/7")
    public String gameinfo07(Model model) {
        game_id = 7;
        CommentController.game_id = 7;
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setConum(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);
        return "gameinfo";
    }
}