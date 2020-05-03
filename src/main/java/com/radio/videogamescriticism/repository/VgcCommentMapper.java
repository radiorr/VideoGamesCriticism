package com.radio.videogamescriticism.repository;

import com.radio.videogamescriticism.domain.VgcComment;

import java.util.List;

public interface VgcCommentMapper {


    public List<VgcComment> getAll();

    public List<VgcComment> getcomment(int game_id);

    public void insertcomment(int user_id, String game_comment);

}