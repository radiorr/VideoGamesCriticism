package com.radio.videogamescriticism.service;

import com.radio.videogamescriticism.domain.VgcGame;

import java.util.List;


public interface VgcGameService {
    List<VgcGame> getAll();

    VgcGame getOne(int game_id);

    double getOnesumgrade(int game_id);

    int getOneconnum(int game_id);

    List<VgcGame> getAllinfo();

}
