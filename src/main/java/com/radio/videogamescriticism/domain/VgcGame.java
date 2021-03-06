package com.radio.videogamescriticism.domain;

public class VgcGame {
    private int game_id;
    private String game_zname;
    private String game_ename;
    private String game_pic_url;
    private String game_date;
    private String game_terrace;
    private String game_info;
    private String game_group;
    private int conum;
    private double sumgrade;

    public int getConum() {
        return conum;
    }

    public void setConum(int conum) {
        this.conum = conum;
    }

    public double getSumgrade() {
        return sumgrade;
    }

    public void setSumgrade(double sumgrade) {
        this.sumgrade = sumgrade;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getGame_zname() {
        return game_zname;
    }

    public void setGame_zname(String game_zname) {
        this.game_zname = game_zname;
    }

    public String getGame_ename() {
        return game_ename;
    }

    public void setGame_ename(String game_ename) {
        this.game_ename = game_ename;
    }

    public String getGame_pic_url() {
        return game_pic_url;
    }

    public void setGame_pic_url(String game_pic_url) {
        this.game_pic_url = game_pic_url;
    }

    public String getGame_date() {
        return game_date;
    }

    public void setGame_date(String game_date) {
        this.game_date = game_date;
    }

    public String getGame_terrace() {
        return game_terrace;
    }

    public void setGame_terrace(String game_terrace) {
        this.game_terrace = game_terrace;
    }

    public String getGame_info() {
        return game_info;
    }

    public void setGame_info(String game_info) {
        this.game_info = game_info;
    }

    public String getGame_group() {
        return game_group;
    }

    public void setGame_group(String game_group) {
        this.game_group = game_group;
    }

    @Override
    public String toString() {
        return "VgcGame{" +
                "game_id=" + game_id +
                ", game_zname='" + game_zname + '\'' +
                ", game_ename='" + game_ename + '\'' +
                ", game_pic_url='" + game_pic_url + '\'' +
                ", game_date='" + game_date + '\'' +
                ", game_terrace='" + game_terrace + '\'' +
                ", game_info='" + game_info + '\'' +
                ", game_group='" + game_group + '\'' +
                ", conum=" + conum +
                ", sumgrade=" + sumgrade +
                '}';
    }
}