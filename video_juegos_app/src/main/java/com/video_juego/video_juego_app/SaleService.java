package com.video_juego.video_juego_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SaleService {

    public static void saveSale(Sale sale){

        SaleDAO.createSaleDB(sale);

    }

    public static Integer getIdNAEUJPOtherGlobal(Double NA_Sales, Double EU_Sales, Double JP_Sales, Double Other_Sales, Double Global_Sales){

        Integer id = null;
        ResultSet rs = null;

        rs = SaleDAO.getIdNAEUJPOtherGlobalDB(NA_Sales,EU_Sales,JP_Sales,Other_Sales,Global_Sales);

        try{
            while (rs.next()){
                id = rs.getInt("id_sale");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public static void updateSale(int id_sales){

        Scanner sc = new Scanner(System.in);

        System.out.println("Update Sales");


        System.out.println("Write NA_Sales");
        Double NA_Sales = Double.valueOf(sc.nextLine());

        System.out.println("Write EU_Sales");
        Double EU_Sales = Double.valueOf(sc.nextLine());

        System.out.println("Write JP_Sales");
        Double JP_Sales = Double.valueOf(sc.nextLine());

        System.out.println("Write Other_Sales");
        Double Other_Sales = Double.valueOf(sc.nextLine());

        System.out.println("Write Global_Sales");
        Double Global_Sales = Double.valueOf(sc.nextLine());



        Sale sale1 = new Sale();
        sale1.setId_Sale(id_sales);
        sale1.setNA_Sales(NA_Sales);
        sale1.setEU_Sales(EU_Sales);
        sale1.setJP_Sales(JP_Sales);
        sale1.setOther_Sales(Other_Sales);
        sale1.setGlobal_Sales(Global_Sales);
        SaleDAO.updateSaleDB(sale1);


    }


}
