package com.video_juego.video_juego_app;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GameService {

    public static void createGame(Game game){

        GameDAO.createGameDB(game);

    }

    public static void listGame(){
        ResultSet rs = null;
        rs = GameDAO.readGameDB();
        System.out.println("Game read");
        try {
            while (rs.next()){
                System.out.println(rs.getInt("id_game"));
                System.out.println(rs.getString("name_game"));
                System.out.println(rs.getString("genre"));
                System.out.println(rs.getInt("id_publisher_fk"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void  deleteGame(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Id game to delete it");
        int idGame = sc.nextInt();
        GameDAO.deleteGameDB(idGame);

    }

    public static void  updateGame(int idGame){

        Scanner sc = new Scanner(System.in);

        System.out.println("Update game");
        //System.out.println("Write id game");
        //Integer idGame = Integer.valueOf(sc.nextLine());

        System.out.println("Write Name game");
        String nameGame = sc.nextLine();

        System.out.println("Write Genre");
        String genre = sc.nextLine();

        //System.out.println("Write id_publisher_fk");
        //Integer id_publi_fk = Integer.valueOf(sc.nextLine());

        Game game = new Game();
        game.setId_game(idGame);
        game.setName_game(nameGame);
        game.setGenre(genre);
        //game.setId_publisher_fk(id_publisher);
        GameDAO.updateGameDB(game);

    }

    public static Integer getIdGameNameGenrefrom(String name_game, String Genre, Integer id_publisher){


        Integer id=null;
        ResultSet rs = null;

        rs =   GameDAO.getIdGameNameGenrefromDB(name_game,Genre,id_publisher);

        try {
            while (rs.next()){

                id = rs.getInt("id_game");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;

    }

}
