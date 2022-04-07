package com.video_juego.video_juego_app;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PublisherPlatformService {

    public static Integer getIdPublisherPlatformfrom(String publisher, String platform){

        Integer id = null;
        ResultSet rs = null;
        rs = PublisherPlatformDAO.idPublisherPlatformDB(publisher, platform);

        try {
            while(rs.next()){

                id = rs.getInt("id_publisher_platform");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }
    public static void savePublisherPlatform(PublisherPlatform publisherPlatform){

        PublisherPlatformDAO.savePublisherPlatformDB(publisherPlatform);

    }

    public static void updatePublisherPlatform(int id_publisher_platform){

        Scanner sc = new Scanner(System.in);

        System.out.println("Update Publisher platform");


        System.out.println("Write Name publisher");
        String publisher = sc.nextLine();

        System.out.println("Write platform");
        String platform = sc.nextLine();



        PublisherPlatform publisherPlatform = new PublisherPlatform();
        publisherPlatform.setPlatform(platform);
        publisherPlatform.setPublisher(publisher);
        publisherPlatform.setIdPublisherPlatform(id_publisher_platform);
        PublisherPlatformDAO.updatePublisherPlatformDB(publisherPlatform);
    }
}
