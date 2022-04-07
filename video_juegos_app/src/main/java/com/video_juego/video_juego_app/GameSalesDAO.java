package com.video_juego.video_juego_app;

import org.eclipse.persistence.internal.libraries.asm.tree.TryCatchBlockNode;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GameSalesDAO {

    public static void createGameSalesDB(GameSales gameSales){
        Conexion connection = new Conexion();

        try(Connection connection1 = connection.getConnection()){
            PreparedStatement ps = null;
            try {

                String sqlStament = "INSERT INTO public.game_sales(id_game_fk, id_publisher_fk, id_sales_fk) VALUES(?,?,?)";
                ps = connection1.prepareStatement(sqlStament);
                ps.setInt(1, gameSales.getIdGameFk());
                ps.setInt(2,gameSales.getIdPublisherFk());
                ps.setInt(3,gameSales.getIdSalesFk());

                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet readRecordsDB(){

        Conexion conexion = new Conexion();
        ResultSet rs = null;

        try(Connection connection = conexion.getConnection()) {
            PreparedStatement ps = null;
            try {

                String sqlStament= "WITH table_c AS ( " +
                        "WITH table_b AS (  " +
                        "WITH table_a AS (  SELECT GS.id_game_sales, GS.id_game_fk, GS.id_publisher_fk, GS.id_sales_fk, G.id_game, G.name_game, G.genre  FROM public.game_sales GS JOIN public.game G ON GS.id_game_fk = G.id_game) " +
                        "SELECT * FROM table_a JOIN publisher p ON table_a.id_publisher_fk = p.id_publisher) " +
                        "SELECT * FROM table_b JOIN publisher_platform PP ON table_b.id_publisher_platform_fk = PP.id_publisher_platform) " +
                        "SELECT * FROM table_C JOIN sale ON table_c.id_sales_fk = sale.id_sale";

                ps = connection.prepareStatement(sqlStament);
                rs = ps.executeQuery();

            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  rs;
    }

    public static void deleteRecordGameSalesDB(int id_Game_Sales){

        Conexion conexion = new Conexion();
        ResultSet rs = null;

        Integer id_game= null;
        try(Connection connection = conexion.getConnection()) {

            PreparedStatement ps = null;

            try {

                //With the Id_game_sales SELECT the sales related to drop it.
                String sqlStament = "SELECT id_sales_fk FROM public.game_sales WHERE id_game_sales = ?";
                ps = connection.prepareStatement(sqlStament);
                ps.setInt(1,id_Game_Sales);
                rs = ps.executeQuery();
                while (rs.next()){
                     id_game = rs.getInt("id_sales_fk");
                }


                sqlStament = "DELETE FROM public.game WHERE id_game = ?";
                ps = connection.prepareStatement(sqlStament);
                ps.setInt(1,id_game);
                int row_delete = ps.executeUpdate();
                System.out.println(row_delete);

                //Then drop the register from game_sales
                sqlStament= "DELETE FROM public.game_sales WHERE id_game_sales = ?";
                ps = connection.prepareStatement(sqlStament);
                ps.setInt(1,id_Game_Sales);
                row_delete = ps.executeUpdate();
                System.out.println(row_delete);


            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static ResultSet updateRecordDB(int id_game_sales){

        Conexion conexion = new Conexion();
        ResultSet rs = null;


        try(Connection connection = conexion.getConnection()) {

            PreparedStatement ps = null;

            try {

                //With the Id_game_sales SELECT the sales related to drop it.

                String sqlStament = "SELECT * FROM public.game_sales WHERE id_game_sales = ?";
                ps = connection.prepareStatement(sqlStament);
                ps.setInt(1,id_game_sales);
                rs = ps.executeQuery();


            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
