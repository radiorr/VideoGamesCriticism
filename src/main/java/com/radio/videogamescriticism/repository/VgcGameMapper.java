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

    @Select("SELECT vgc_game.game_id,game_zname,sum(game_grade)/count(user_id) as game_info ,game_group,game_pic_url\n" +
            "FROM vgc_game left join vgc_grade on vgc_game.game_id=vgc_grade.game_id\n" +
            "group by vgc_game.game_id")
    List<VgcGame> getAllinfo();


}