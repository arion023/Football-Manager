package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;

import java.util.List;

public class User {

    private int id;
    private String login;
    private String password;
    private String mail;
    private int budget;
    private int club_id;
    public User(){
        //TODO
        DatabaseController dbController = new DatabaseController();
        //String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));

    }



    public int getBudget(){
        return this.budget;
    }

    public boolean buy(int price){

        //TODO checking if operation complete
        return true;
    }

    static public boolean addNewUser(int id, String login, String password, String mail, int budget, int club_id){
        DatabaseController dbController = new DatabaseController();

        //TODO checking if operation complete
        return true;
    }
}
