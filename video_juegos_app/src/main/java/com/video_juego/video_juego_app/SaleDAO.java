package com.video_juego.video_juego_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaleDAO {

    public static void createSaleDB(Sale sale){
        Conexion connection = new Conexion();

        try(Connection connection1 = connection.getConnection()){
            PreparedStatement ps = null;

            try{
                String sqlstament = "INSERT INTO public.sale(" +  "\"NA_Sales\", \"EU_Sales\", \"JP_Sales\", \"Other_Sales\", \"Global_Sales\")" + "VALUES (?, ?, ?, ?, ?)";
                ps = connection1.prepareStatement(sqlstament);

                ps.setDouble(1,sale.getNA_Sales());
                ps.setDouble(2,sale.getEU_Sales());
                ps.setDouble(3,sale.getJP_Sales());
                ps.setDouble(4,sale.getOther_Sales());
                ps.setDouble(5,sale.getGlobal_Sales());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getIdNAEUJPOtherGlobalDB(Double NA_Sales, Double EU_Sales, Double JP_Sales, Double Other_Sales, Double Global_Sales){


        Conexion connection = new Conexion();
        ResultSet rs = null;
        try(Connection connection1 = connection.getConnection()){
            PreparedStatement ps =null;

            try{
                String sqlStament = "SELECT id_sale from public.sale WHERE \"NA_Sales\"=? AND \"EU_Sales\"=? AND \"JP_Sales\"=? AND \"Other_Sales\"=? AND \"Global_Sales\"=?";
                ps = connection1.prepareStatement(sqlStament);
                ps.setDouble(1,NA_Sales);
                ps.setDouble(2,EU_Sales);
                ps.setDouble(3,JP_Sales);
                ps.setDouble(4,Other_Sales);
                ps.setDouble(5,Global_Sales);
                rs = ps.executeQuery();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return rs;
    }

    public static void updateSaleDB(Sale sale) {

        Conexion connection = new Conexion();
        ResultSet rs = null;
        try(Connection connection1 = connection.getConnection()){
            PreparedStatement ps =null;

            try{
                String sqlStament = "UPDATE public.sale SET \"NA_Sales\"=?, \"EU_Sales\"=? ,\"JP_Sales\"=? ,\"Other_Sales\"=? ,\"Global_Sales\"=? WHERE id_sale=?";
                ps = connection1.prepareStatement(sqlStament);
                ps.setDouble(1,sale.getNA_Sales());
                ps.setDouble(2,sale.getEU_Sales());
                ps.setDouble(3,sale.getJP_Sales());
                ps.setDouble(4,sale.getOther_Sales());
                ps.setDouble(5,sale.getGlobal_Sales());
                ps.setInt(6,sale.getId_Sale());
                int RowUpdated = ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
