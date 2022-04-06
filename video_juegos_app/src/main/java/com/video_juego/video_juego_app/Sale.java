package com.video_juego.video_juego_app;

public class Sale {

    Integer id_Sale;
    Double NA_Sales;
    Double EU_Sales;
    Double JP_Sales;
    Double Other_Sales;
    Double Global_Sales;

    public Sale(){

    }

    public Sale(Integer id_Sale, Double NA_Sales, Double EU_Sales, Double JP_Sales, Double other_Sales, Double global_Sales) {
        this.id_Sale = id_Sale;
        this.NA_Sales = NA_Sales;
        this.EU_Sales = EU_Sales;
        this.JP_Sales = JP_Sales;
        Other_Sales = other_Sales;
        Global_Sales = global_Sales;
    }

    public Integer getId_Sale() {
        return id_Sale;
    }

    public void setId_Sale(Integer id_Sale) {
        this.id_Sale = id_Sale;
    }

    public Double getNA_Sales() {
        return NA_Sales;
    }

    public void setNA_Sales(Double NA_Sales) {
        this.NA_Sales = NA_Sales;
    }

    public Double getEU_Sales() {
        return EU_Sales;
    }

    public void setEU_Sales(Double EU_Sales) {
        this.EU_Sales = EU_Sales;
    }

    public Double getJP_Sales() {
        return JP_Sales;
    }

    public void setJP_Sales(Double JP_Sales) {
        this.JP_Sales = JP_Sales;
    }

    public Double getOther_Sales() {
        return Other_Sales;
    }

    public void setOther_Sales(Double other_Sales) {
        Other_Sales = other_Sales;
    }

    public Double getGlobal_Sales() {
        return Global_Sales;
    }

    public void setGlobal_Sales(Double global_Sales) {
        Global_Sales = global_Sales;
    }
}
