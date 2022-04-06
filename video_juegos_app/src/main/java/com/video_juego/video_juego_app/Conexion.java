package com.video_juego.video_juego_app;


import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    String user = "postgres";
    String password = "Revolver_12";

    public Connection getConnection(){
       Connection connection = null;
       try{
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Game_sales", user, password);
           //System.out.println("connexion successful");
       }catch (Exception e){
            System.out.println(e.getMessage());
       }

       return connection;
    }
}
