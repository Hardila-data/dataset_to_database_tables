package com.video_juego.video_juego_app;

import java.sql.ResultSet;
import java.util.Scanner;

public class PreOrder {

    //This class start update the classes in order
    public static void createRegister(){
        String publisher;
        String platform;
        String year;
        Double NA_Sales;
        Double EU_Sales;
        Double JP_Sales;
        Double Other_Sales;
        Double Global_Sales;
        String name_game;
        String genre;

        Integer idPublisherPlatform;
        Integer id_publisher_fk;
        Integer id_game_fk;
        Integer id_sale_fk;

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert Game name");
        name_game = sc.nextLine();
        System.out.println("Insert genre game");
        genre = sc.nextLine();
        System.out.println("Insert publisher");
        publisher = sc.nextLine();
        System.out.println("Insert platform");
        platform = sc.nextLine();
        System.out.println("Insert year published");
        year = sc.nextLine();
        System.out.println("Insert NA_Sales");
        NA_Sales = Double.valueOf(sc.nextLine());
        System.out.println("Insert EU_Sales");
        EU_Sales = Double.valueOf(sc.nextLine());
        System.out.println("Insert JP_Sales");
        JP_Sales = Double.valueOf(sc.nextLine());
        System.out.println("Insert Other_Sales");
        Other_Sales = Double.valueOf(sc.nextLine());
        System.out.println("Insert Global_Sales");
        Global_Sales = Double.valueOf(sc.nextLine());

        //Create register in publisherPlatform
        PublisherPlatform publisherPlatform = new PublisherPlatform();
        publisherPlatform.setPublisher(publisher);
        publisherPlatform.setPlatform(platform);
        PublisherPlatformService.savePublisherPlatform(publisherPlatform);

        //Search value in PublisherPlaform to assing as FK in the next table
        idPublisherPlatform = PublisherPlatformService.getIdPublisherPlatformfrom(publisher,platform);

        System.out.println(idPublisherPlatform);
        Publisher publisher1 = new Publisher();
        publisher1.setYear(year);
        publisher1.setId_publisher_platform_fk(idPublisherPlatform);
        PublisherService.savePublisher(publisher1);

        Sale sale = new Sale();
        sale.setNA_Sales(NA_Sales);
        sale.setEU_Sales(EU_Sales);
        sale.setJP_Sales(JP_Sales);
        sale.setOther_Sales(Other_Sales);
        sale.setGlobal_Sales(Global_Sales);

        SaleService.saveSale(sale);

        Game game = new Game();
        game.setName_game(name_game);
        game.setGenre(genre);

        id_publisher_fk = PublisherService.getIdpublisheryearfrom(idPublisherPlatform,year);
        game.setId_publisher_fk(id_publisher_fk);
        GameService.createGame(game);

        id_game_fk = GameService.getIdGameNameGenrefrom(name_game,genre,id_publisher_fk);


        id_sale_fk = SaleService.getIdNAEUJPOtherGlobal(NA_Sales,EU_Sales,JP_Sales,Other_Sales,Global_Sales);

        //Save full record Game_Sales
        GameSales gameSales = new GameSales();
        gameSales.setIdGameFk(id_game_fk);
        gameSales.setIdPublisherFk(id_publisher_fk);
        gameSales.setIdSalesFk(id_sale_fk);
        GameSalesService.createGameSales(gameSales);

    }

    public static void readRecords(){

        GameSalesService.readRecordsGameSales();
    }

    public static void deleteRecord(){

        int id_game_sale;

        Scanner sc = new Scanner(System.in);
        System.out.println("Insert id register you want to delete");
        id_game_sale = sc.nextInt();
        GameSalesService.deleteRecordGameSales(id_game_sale);
    }

    public static void updateRecord(){

        int id_game_sale;
        Scanner sc = new Scanner(System.in);
        System.out.println("Insert id Register to update");
        id_game_sale = sc.nextInt();
        GameSalesService.updateRecord(id_game_sale);
    }

}
