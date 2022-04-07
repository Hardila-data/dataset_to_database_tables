package com.video_juego.video_juego_app;

public class Publisher {

    Integer id_publisher;
    Integer id_publisher_platform_fk;
    String year;

    public Publisher(){

    }

    public Publisher(Integer id_publisher, Integer id_publisher_platform_fk, String year) {
        this.id_publisher = id_publisher;
        this.id_publisher_platform_fk = id_publisher_platform_fk;
        this.year = year;
    }

    public Integer getId_publisher() {
        return id_publisher;
    }

    public void setId_publisher(Integer id_publisher) {
        this.id_publisher = id_publisher;
    }

    public Integer getId_publisher_platform_fk() {
        return id_publisher_platform_fk;
    }

    public void setId_publisher_platform_fk(Integer id_publisher_platform_fk) {
        this.id_publisher_platform_fk = id_publisher_platform_fk;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
