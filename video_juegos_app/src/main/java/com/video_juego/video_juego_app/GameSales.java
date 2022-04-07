package com.video_juego.video_juego_app;

public class GameSales {

    Integer idGameSales;
    Integer idGameFk;
    Integer idPublisherFk;
    Integer idSalesFk;

    public GameSales(){

    }

    public GameSales(Integer idGameSales, Integer idGameFk, Integer idPublisherFk, Integer idSalesFk) {
        this.idGameSales = idGameSales;
        this.idGameFk = idGameFk;
        this.idPublisherFk = idPublisherFk;
        this.idSalesFk = idSalesFk;
    }

    public Integer getIdGameSales() {
        return idGameSales;
    }

    public void setIdGameSales(Integer idGameSales) {
        this.idGameSales = idGameSales;
    }

    public Integer getIdGameFk() {
        return idGameFk;
    }

    public void setIdGameFk(Integer idGameFk) {
        this.idGameFk = idGameFk;
    }

    public Integer getIdPublisherFk() {
        return idPublisherFk;
    }

    public void setIdPublisherFk(Integer idPublisherFk) {
        this.idPublisherFk = idPublisherFk;
    }

    public Integer getIdSalesFk() {
        return idSalesFk;
    }

    public void setIdSalesFk(Integer idSalesFk) {
        this.idSalesFk = idSalesFk;
    }
}
