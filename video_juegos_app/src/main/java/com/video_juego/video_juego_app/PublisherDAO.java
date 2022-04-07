package com.video_juego.video_juego_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PublisherDAO {

    public static void createPublisherDB(Publisher publisher){
        Conexion db_connect = new Conexion();

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO public.publisher(id_publisher_platform_fk, year) VALUES ( ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setInt(1, publisher.getId_publisher_platform_fk());
                ps.setString(2, publisher.getYear());
                ps.executeUpdate();
                System.out.println("New Publisher Created");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void savePublisherDB(Publisher publisher){
        Conexion db_connect = new Conexion();

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO public.publisher(id_publisher_platform_fk, year) VALUES ( ?, ?)";
                ps = connection.prepareStatement(query);
                ps.setInt(1, publisher.getId_publisher_platform_fk());
                ps.setString(2, publisher.getYear());
                ps.executeUpdate();
                System.out.println("New Publisher Created");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet readPublisherDB(){
        Conexion db_connect = new Conexion();
        ResultSet rs =null;

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;


            try {
                String query = "SELECT * FROM public.publisher";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();

                /*while(rs.next()){
                    System.out.println("ID: "+rs.getInt("id_publisher"));
                    System.out.println("ID: "+rs.getInt("id_publisher_platform_fk"));
                    System.out.println("ID: "+rs.getString("year"));
                }*/

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static Integer getIdPublisherPlatformDB(Integer id_publisher){

        Integer id_publisher_platform = null;
        Conexion db_connect = new Conexion();
        ResultSet rs =null;

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;


            try {
                String query = "SELECT id_publisher_platform_fk FROM public.publisher WHERE id_publisher = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, id_publisher);
                rs = ps.executeQuery();

                while(rs.next()){

                    id_publisher_platform = rs.getInt("id_publisher_platform_fk");

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

        return id_publisher_platform;
    }

    public static void deletePublisherDB(int id_publisher){
        Conexion db_connect = new Conexion();

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM public.publisher WHERE id_publisher = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1,id_publisher);
                int rowsUpdate = ps.executeUpdate();
                System.out.println("Delete Publisher");
                System.out.println(rowsUpdate);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updatePublisherDB(Publisher publisher){

        Conexion db_connect = new Conexion();

        try(Connection connection = db_connect.getConnection()) {

            PreparedStatement ps = null;
            try {
                String query = "UPDATE public.publisher SET id_publisher_platform_fk=?, year=? WHERE id_publisher = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, publisher.getId_publisher_platform_fk());
                ps.setString(2, publisher.getYear());
                ps.setInt(3,publisher.getId_publisher());
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

    public static ResultSet getIdpublisheryearfromDB(Integer id, String year){

        Conexion connection = new Conexion();
        ResultSet rs = null;
        try(Connection connection1 = connection.getConnection()){
            PreparedStatement ps =null;
            try{
                String sqlStament = "SELECT id_publisher from public.publisher WHERE id_publisher_platform_fk=? AND year=?";

                ps = connection1.prepareStatement(sqlStament);
                ps.setInt(1,id);
                ps.setString(2,year);
                rs = ps.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return rs;
    }

}
