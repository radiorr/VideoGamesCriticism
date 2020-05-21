package com.radio.videogamescriticism.service;


import com.radio.videogamescriticism.domain.VgcGame;
import com.radio.videogamescriticism.repository.VgcGameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vgcgameService")
public class VgcGameServiceImpl implements VgcGameService{
    @Autowired
    private VgcGameMapper vgcgamemapper;

    @Override
    public List<VgcGame> getAll(){
        return vgcgamemapper.getAll();
    };
    @Override
    public VgcGame getOne(int game_id) {
        return vgcgamemapper.getOne(game_id);
    };
    @Override
    public double getOnesumgrade(int game_id){
        return vgcgamemapper.getOnesumgrade(game_id);
    };
    @Override
    public int getOneconnum(int game_id){
        return vgcgamemapper.getOneconnum(game_id);
    };
    @Override
    public List<VgcGame> getAllinfo() {
        return vgcgamemapper.getAllinfo();
    }

    ;

    @Override
    public List<VgcGame> gettaggame(String tag) {
        return vgcgamemapper.gettaggame(tag);
    }

    ;

}