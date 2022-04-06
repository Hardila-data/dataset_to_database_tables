package com.video_juego.video_juego_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PublisherPlatformDAO {

    public static void createPublisherPlatformDB(PublisherPlatform publisherPlatform) {
        Conexion connection = new Conexion();

        try (Connection connection1 = connection.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO public.publisher_platform(publisher, platform) VALUES(?, ?)";
                ps = connection1.prepareStatement(query);
                ps.setString(1, publisherPlatform.getPublisher());
                ps.setString(2, publisherPlatform.getPlatform());
                ps.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet idPublisherPlatformDB(String publisher, String platform){
        Conexion connection = new Conexion();
        ResultSet rs = null;
        try(Connection connection1 = connection.getConnection()){
            PreparedStatement ps =null;
            try{
                String sqlStament = "SELECT id_publisher_platform from public.publisher_platform WHERE publisher=? AND platform=?";
                //String sqlStament = "SELECT * FROM public.publisher_platform";
                ps = connection1.prepareStatement(sqlStament);
                ps.setString(1,publisher);
                ps.setString(2,platform);
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


    public static void savePublisherPlatformDB(PublisherPlatform publisherPlatform){

        Conexion db_connect = new Conexion();

        try (Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO public.publisher_platform (publisher,platform) VALUES (?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, publisherPlatform.getPublisher());
                ps.setString(2, publisherPlatform.getPlatform());
                ps.executeUpdate();
                System.out.println(ps);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePublisherPlatformDB(PublisherPlatform publisherPlatform){


        Conexion db_connect = new Conexion();

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "UPDATE public.publisher_platform SET publisher=?, platform=? WHERE id_publisher_platform = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, publisherPlatform.getPublisher());
                ps.setString(2, publisherPlatform.getPlatform());
                ps.setInt(3,publisherPlatform.getIdPublisherPlatform());
                ps.executeUpdate();
                System.out.println("Publisher Updated");
            } catch (SQLException e) {

                e.printStackTrace();
                System.out.println("Cannot Updated Publisher");
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
