package com.video_juego.video_juego_app;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GameSalesService {

    public static void createGameSales(GameSales gameSales){

        GameSalesDAO.createGameSalesDB(gameSales);
    }

    public static void readRecordsGameSales(){

        ResultSet rs = null;

        rs = GameSalesDAO.readRecordsDB();
        //int i =0;
        try {

            while (rs.next()){

                String column_id_record = rs.getString("id_game_sales");
                String column_name_game = rs.getString("name_game");
                String column_genre = rs.getString("genre");
                String column_year = rs.getString("year");
                String column_platform = rs.getString("platform");
                Double column_NA_Sales = rs.getDouble("NA_Sales");
                Double column_EU_Sales = rs.getDouble("EU_Sales");
                Double column_JP_Sales = rs.getDouble("JP_Sales");
                Double column_Other_Sales = rs.getDouble("Other_Sales");
                Double column_Global_Sales = rs.getDouble("Global_Sales");



                System.out.println("Id record : " + column_id_record);
                System.out.println("Game : " + column_name_game);
                System.out.println("Genre : " + column_genre);
                System.out.println("year : " + column_year );
                System.out.println("platform" + column_platform);
                System.out.println("NA_Sales"+column_NA_Sales);
                System.out.println("EU_Sales"+column_EU_Sales);
                System.out.println("JP_Sales"+column_JP_Sales);
                System.out.println("Other_Sales"+column_Other_Sales);
                System.out.println("Global_Sales"+column_Global_Sales);

                //System.out.println(rs.getInt("id_publisher_fk"));
                System.out.println("-------------------");
                //i=i+1;
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public static void deleteRecordGameSales(int ind_game_sales){

        GameSalesDAO.deleteRecordGameSalesDB(ind_game_sales);

    }

    public static void updateRecord(int id_game_sales){

        ResultSet rs = null;
        Integer id_game= null;
        Integer id_publisher = null;
        Integer id_sales = null;
        Integer id_publisher_platform_fk = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("What do you want to update?");

        rs = GameSalesDAO.updateRecordDB(id_game_sales);
        try {
            while (rs.next()){

                id_game = rs.getInt("id_game_fk");
                id_publisher = rs.getInt("id_publisher_fk");
                System.out.println(id_publisher+ "SSSSS");
                id_sales = rs.getInt("id_sales_fk");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(id_game);
        int option=0;


        do{
            System.out.println("-------------------------");
            System.out.println(" Register Video game");
            System.out.println("1. Game");
            System.out.println("2. Publisher");
            System.out.println("3. Sales");
            System.out.println("4. Exit");

            option = sc.nextInt();

            switch (option){
                case 1:
                    GameService.updateGame(id_game);
                    break;
                case 2:
                    id_publisher_platform_fk = PublisherService.getIdPublisherPlatform(id_publisher);
                    PublisherPlatformService.updatePublisherPlatform(id_publisher_platform_fk);
                    break;
                case 3:
                    SaleService.updateSale(id_sales);
                    break;
                default:
                    break;

            }
            GameSalesDAO.updateRecordDB(id_game_sales);

        }while(option !=4);


    }

}
