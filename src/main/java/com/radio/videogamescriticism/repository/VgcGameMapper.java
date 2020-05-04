package com.radio.videogamescriticism.repository;

import com.radio.videogamescriticism.domain.VgcGame;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VgcGameMapper {

    @Select("SELECT * FROM vgc_game")
    List<VgcGame> getAll();

    @Select("SELECT * FROM vgc_game WHERE game_id = #{game_id}")
    VgcGame getOne(int game_id);

    @Select("select sum(game_grade) from vgc_db.vgc_grade" +
            "where game_id='#{game_id}'")
    double getOnesumgrade(int game_id);

    @Select("SELECT count(user_id) FROM vgc_db.vgc_grade" +
            "where game_id='#{game_id}'")
    int getOneconnum(int game_id);

    @Select("SELECT game_id,game_zname,game_group,game_pic_url FROM vgc_game")
    List<VgcGame> getAllinfo();
}