package com.video_juego.video_juego_app;

public class PublisherPlatform {

    Integer idPublisherPlatform;
    String publisher;
    String platform;

    public PublisherPlatform(){

    }

    public PublisherPlatform(Integer idPublisherPlatform, String publisher, String platform) {
        this.idPublisherPlatform = idPublisherPlatform;
        this.publisher = publisher;
        this.platform = platform;
    }

    public Integer getIdPublisherPlatform() {
        return idPublisherPlatform;
    }

    public void setIdPublisherPlatform(Integer idPublisherPlatform) {
        this.idPublisherPlatform = idPublisherPlatform;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }



}
