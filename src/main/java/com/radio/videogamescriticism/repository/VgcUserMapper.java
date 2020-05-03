package com.radio.videogamescriticism.repository;


import com.radio.videogamescriticism.domain.VgcUser;
import org.apache.ibatis.annotations.*;


import java.util.List;

public interface VgcUserMapper {

    @Select("SELECT * FROM vgc_user")
    public List<VgcUser> getAll();

    @Select("SELECT * FROM vgc_user WHERE username = #{username}")
    public VgcUser getOne(String username);
    //账号密码检查
    @Select("SELECT username,password FROM vgc_user WHERE username = #{username} and password = #{password} ")
    public VgcUser checkOne(String username, String password);
    //重名检测
    @Select("SELECT * FROM vgc_user WHERE username = #{username} ")
    public VgcUser renamecheck(String username);

    @Insert("INSERT INTO vgc_user(username,password,nickname) VALUES(#{username},#{password},#{nickname})")
    public void insert(String username, String password, String nickname);

    @Update("UPDATE vgc_user SET password=#{password} WHERE username =#{username}")
    public void uppassword(VgcUser user);

    @Update("UPDATE vgc_user SET nickname=#{nickname} WHERE username =#{username}")
    public void upnickname(VgcUser user);

    @Delete("DELETE FROM vgc_user WHERE username =#{username}")
    public void delete(String username);

    @Select("SELECT password FROM vgc_user WHERE username = #{username}")
    public String getPassword(String username);


}
