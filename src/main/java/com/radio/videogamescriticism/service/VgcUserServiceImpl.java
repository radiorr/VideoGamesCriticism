package com.radio.videogamescriticism.service;

import com.radio.videogamescriticism.domain.VgcUser;
import com.radio.videogamescriticism.repository.VgcUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("vgcuserService")
public class VgcUserServiceImpl implements VgcUserService{
    @Autowired
    private VgcUserMapper vgcusermapper;

    @Override
    public List<VgcUser> getAll(){
        return vgcusermapper.getAll();
    };
    @Override
    public VgcUser getOne(String username){
        return vgcusermapper.getOne(username);
    };
    @Override
    public void insert(String rnumber, String rpassword, String nickname){
         vgcusermapper.insert(rnumber,rpassword,nickname);
    };
    @Override
    public void uppassword(VgcUser user){
         vgcusermapper.uppassword(user);
    };
    @Override
    public void upnickname(VgcUser user){
         vgcusermapper.upnickname(user);
    };
    @Override
    public void delete(String username){
         vgcusermapper.delete(username);
    };
    @Override
    public VgcUser checkOne(String username, String password){
        return vgcusermapper.checkOne(username,password);
    };
    @Override
    public VgcUser renamecheck(String username){
        return vgcusermapper.renamecheck(username);
    };
    @Override
    public String getPassword(String username){
        return vgcusermapper.getPassword(username);
    };
}