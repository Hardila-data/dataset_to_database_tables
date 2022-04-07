package com.video_juego.video_juego_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class inicio {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int option=0;

        //System.out.println("INSERT INTO public.sale("  +'"'+  "NA_Sales" +'"'+ ","+  +'"'+  "EU_Sales" +'"'+ ","+  +'"'+ "JP_Sales"  +'"'+ ","+ +'"'+ "Other_Sales"  +'"'+ ","+  +'"'+ "Global_Sales"+'"'+ "VALUES(?,?,?,?,?)");
        //System.out.println("INSERT INTO public.sale(" +  "\"NA_Sales\", \"EU_Sales\", \"JP_Sales\", \"Other_Sales\", \"Global_Sales\")" + "VALUES (?, ?, ?, ?, ?)");
        //System.out.println("SELECT id_sale from public.sale WHERE \"NA_Sales\"=? AND \"EU_Sales\"=? AND \"JP_Sales\"=? AND \"Other_Sales\"=? AND \"Global_Sales\"=?");
        do{
            System.out.println("-------------------------");
            System.out.println(" Register Video game");
            System.out.println("1. Create Register");
            System.out.println("2. List Register");
            System.out.println("3. Delete Register");
            System.out.println("4. Update Register");
            System.out.println("5. Exit");

            option = sc.nextInt();

            switch (option){
                case 1:
                    //PublisherService.createPublisher();
                    //GameService.createGame();
                    PreOrder.createRegister();
                    break;
                case 2:
                    //PublisherService.listPublisher();
                    //GameService.listGame();
                    PreOrder.readRecords();
                    break;
                case 3:
                    //GameService.deleteGame();
                    PreOrder.deleteRecord();
                    //PublisherService.deletePublisher();
                    break;
                case 4:
                    PreOrder.updateRecord();
                    //PublisherService.updatePublisher();
                    break;
                default:
                    break;

            }


        }while(option !=5);



        /*Conexion connexion = new Conexion();

        try (Connection cnx = connexion.getConnection()){

        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

}
