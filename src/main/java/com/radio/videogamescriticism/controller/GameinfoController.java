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
        VgcGame game = vgcgameService.getOne(game_id);
        int conum = vgcgameService.getOneconnum(game_id);
        game.setGame_id(conum);
        game.setSumgrade(vgcgameService.getOnesumgrade(game_id) / conum);
        model.addAttribute("game", game);
        return "gameinfo";
    }
}