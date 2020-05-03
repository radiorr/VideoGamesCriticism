package com.radio.videogamescriticism.domain;

public class VgcGrade {
    private int gea_id;
    private int user_id;
    private int game_id;
    private String game_grade;

    public int getGea_id() {
        return gea_id;
    }

    public void setGea_id(int gea_id) {
        this.gea_id = gea_id;
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

    public String getGame_grade() {
        return game_grade;
    }

    public void setGame_grade(String game_grade) {
        this.game_grade = game_grade;
    }
}