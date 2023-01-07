package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;
@Component
public class User {

    public DatabaseController dbController = new DatabaseController();
    private int id;
    private String mail;
    private int budget;
    private Club club;
    public User(){
        //TODO
        //String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));
    }

    public int getBudget(){
        return this.budget;
    }

    public boolean buy(int price){

        //TODO checking if operation complete
        return true;
    }


        //this.setMail(mail);
        //this.setBudget();


    private void setClubByID(int id) {
        //TODO
        int a;
    }


    public void setUserInfo(String mail) {
        ResultSet userInfo = User.getUserInfoFromDB(mail);
        this.mail = mail;
        try {
            while(userInfo.next()) {
                this.mail = userInfo.getString("mail");
                this.budget = userInfo.getInt("budget");
                var club_id = userInfo.getInt("club_id");
                this.setClubByID(club_id);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public boolean addNewUser(int id, String login, String password, String mail, int budget, int club_id){
        DatabaseController dbController = new DatabaseController();

        //TODO checking if operation complete
        return true;
    }

    static public ResultSet getUserInfoFromDB(String mail){
        DatabaseController dbController = new DatabaseController();
        String query = "SELECT * FROM users";
        return dbController.doQuery(query);

    }

}
