package com.video_juego.video_juego_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GameDAO {


    public static void createGameDB(Game game) {
        Conexion db_connect = new Conexion();

        try (Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO public.game (name_game,genre,id_publisher_fk) VALUES (?,?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, game.getName_game());
                ps.setString(2, game.getGenre());
                ps.setInt(3, game.getId_publisher_fk());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ResultSet readGameDB(){
        Conexion db_connect = new Conexion();
        ResultSet rs =null;

        try (Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "SELECT * FROM public.game";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static void deleteGameDB(int idGame) {
        Conexion db_connect = new Conexion();

        try (Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM public.game WHERE id_game = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, idGame);
               int rowsDelete = ps.executeUpdate();
               System.out.println("Delete Game");
               System.out.println(rowsDelete);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updateGameDB(Game game){

        Conexion db_connect = new Conexion();

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
               //String query = "UPDATE public.game SET name_game=?, genre=?,id_publisher_fk=? WHERE id_game = ?";
                String query = "UPDATE public.game SET name_game=?, genre=? WHERE id_game = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, game.getName_game());
                ps.setString(2, game.getGenre());
                //ps.setInt(3,game.getId_publisher_fk());
                ps.setInt(3,game.getId_game());
                ps.executeUpdate();
                System.out.println("game Updated");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Cannot Updated Publisher");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static ResultSet getIdGameNameGenrefromDB(String name_game, String genre, Integer id_publisher){


        Conexion connection = new Conexion();
        ResultSet rs = null;
        try(Connection connection1 = connection.getConnection()){
            PreparedStatement ps =null;
            try{
                String sqlStament = "SELECT id_game from public.game WHERE name_game=? AND genre=? AND id_publisher_fk=?";
                //String sqlStament = "SELECT * FROM public.publisher_platform";
                ps = connection1.prepareStatement(sqlStament);
                ps.setString(1,name_game);
                ps.setString(2,genre);
                ps.setInt(3,id_publisher);
                rs = ps.executeQuery();
                System.out.println(rs);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return rs;

    }

}
