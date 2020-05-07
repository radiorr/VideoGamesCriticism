package com.radio.videogamescriticism.domain;

public class VgcComment {
    private int comm_id;
    private int user_id;
    private int game_id;
    private String game_comment;
    private String com_time;
    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getComm_id() {
        return comm_id;
    }

    public void setComm_id(int comm_id) {
        this.comm_id = comm_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getGame_comment() {
        return game_comment;
    }

    public void setGame_comment(String game_comment) {
        this.game_comment = game_comment;
    }

    public String getCom_time() {
        return com_time;
    }

    public void setCom_time(String com_time) {
        this.com_time = com_time;
    }

    @Override
    public String toString() {
        return "VgcComment{" +
                "comm_id=" + comm_id +
                ", user_id=" + user_id +
                ", game_id=" + game_id +
                ", game_comment='" + game_comment + '\'' +
                ", com_time='" + com_time + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
