package com.video_juego.video_juego_app;

import javax.print.DocFlavor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PublisherService {


    public static void createPublisher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write id_publisher_platform");
        Integer id_pub_plat = Integer.valueOf(sc.nextLine());

        System.out.println("Write year");
        String year = sc.nextLine();

        Publisher publisher_1 = new Publisher();
        publisher_1.setYear(year);

        PublisherDAO.createPublisherDB(publisher_1);


    }

    public static void listPublisher(){
        ResultSet rs =null;
        rs = PublisherDAO.readPublisherDB();
        System.out.println("Publisher read");
        try {
            while(rs.next()) {
                System.out.println("ID: " + rs.getInt("id_publisher"));
                System.out.println("ID_publisher_platform: " + rs.getInt("id_publisher_platform_fk"));
                System.out.println("Year: " + rs.getString("year"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
                    }
    }

    public static Integer getIdPublisherPlatform(Integer id_publisher){

        Integer id = null;
        Integer id_publisher_platform =null;
        id_publisher_platform = PublisherDAO.getIdPublisherPlatformDB(id_publisher);
        System.out.println("Publisher read");

        return id_publisher_platform;
    }



    public static void deletePublisher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Id publisher to delete it");
        int id_publisher = sc.nextInt();
        PublisherDAO.deletePublisherDB(id_publisher);
    }

    public static void updatePublisher(){
        Scanner sc = new Scanner(System.in);
        System.out.println("update publisher_platform");
        int id_pub_plat = Integer.parseInt(sc.nextLine());

        System.out.println("update year");
        String year = sc.nextLine();

        System.out.println("Id publisher to update data");
        int id_publisher = sc.nextInt();

        Publisher publisher = new Publisher();
        publisher.setId_publisher(id_publisher);
        publisher.setId_publisher_platform_fk(id_pub_plat);
        publisher.setYear(year);
        PublisherDAO.updatePublisherDB(publisher);


    }

    public static void savePublisher(Publisher publisher){

        PublisherDAO.savePublisherDB(publisher);
    }

    public static Integer  getIdpublisheryearfrom(Integer id_publisher_platform, String year){

        Integer id=null;
        ResultSet rs = null;

        rs =  PublisherDAO.getIdpublisheryearfromDB(id_publisher_platform, year);
        try {
            while (rs.next()){
                System.out.println(rs.getInt("id_publisher"));
                id = rs.getInt("id_publisher");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
