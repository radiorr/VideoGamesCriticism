package com.radio.videogamescriticism.service;

import com.radio.videogamescriticism.domain.VgcComment;

import java.util.List;


public interface VgcCommentService {

     List<VgcComment> getAll();

     List<VgcComment> getcomment(int game_id);

     void insertcomment(String user_id, String game_id, String game_comment);

}
