package com.video_juego.video_juego_app;

public class Game {
    Integer id_game;
    String name_game;
    String genre;
    Integer id_publisher_fk;

    public Game(){

    }

    public Game(Integer id_game, String name_game, String genre, Integer id_publisher_fk) {
        this.id_game = id_game;
        this.name_game = name_game;
        this.genre = genre;
        this.id_publisher_fk = id_publisher_fk;
    }

    public Integer getId_game() {
        return id_game;
    }

    public void setId_game(Integer id_game) {
        this.id_game = id_game;
    }

    public String getName_game() {
        return name_game;
    }

    public void setName_game(String name_game) {
        this.name_game = name_game;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId_publisher_fk() {
        return id_publisher_fk;
    }

    public void setId_publisher_fk(Integer id_publisher_fk) {
        this.id_publisher_fk = id_publisher_fk;
    }
}
