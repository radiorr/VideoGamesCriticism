package com.radio.videogamescriticism.service;

import com.radio.videogamescriticism.domain.VgcComment;
import com.radio.videogamescriticism.repository.VgcCommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vgccommentservice")
public class VgcCommentServiceImpl implements VgcCommentService{
    @Autowired
    private VgcCommentMapper vgccommentmapper;

    @Override
    public List<VgcComment> getAll(){
        return vgccommentmapper.getAll();
    };
    @Override
    public List<VgcComment> getcomment(int game_id){
        return vgccommentmapper.getcomment(game_id);
    };
    @Override
    public void insertcomment(int user_id, String game_comment){
         vgccommentmapper.insertcomment(user_id,game_comment);
    };

}
