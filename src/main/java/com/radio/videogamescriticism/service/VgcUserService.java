package com.radio.videogamescriticism.service;

import java.util.List;

import com.radio.videogamescriticism.domain.VgcUser;


public interface VgcUserService {
    public List<VgcUser> getAll();

    public VgcUser getOne(String username);

    public void insert(String rnumber, String rpassword, String nickname);

    public void uppassword(VgcUser user);

    public void upnickname(VgcUser user);

    public void delete(String username);

    public VgcUser checkOne(String username, String password);

    public VgcUser renamecheck(String username);

    public String getPassword(String username);

}
