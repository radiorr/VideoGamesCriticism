package com.radio.videogamescriticism.repository;

import com.radio.videogamescriticism.domain.VgcComment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VgcCommentMapper {


    public List<VgcComment> getAll();

    @Select("SELECT vgc_comment.game_id,vgc_comment.user_id,game_comment,com_time,nickname\n" +
            " FROM vgc_comment join vgc_user on vgc_comment.user_id=vgc_user.user_id  " +
            "WHERE game_id = #{game_id}")
    public List<VgcComment> getcomment(int game_id);

    @Insert("INSERT INTO vgc_comment(user_id,game_id,game_comment) VALUES(#{user_id},#{game_id},#{game_comment})")
    public void insertcomment(String user_id, String game_id, String game_comment);

}