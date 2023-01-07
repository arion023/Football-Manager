package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import org.springframework.stereotype.Component;

import java.sql.*;
@Component
public class User {

    private String mail;
    private int budget;
    private int clubID;
    private Club club;

    public User() {
        //TODO
        //String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));
    }


    public int getBudget() {
        return this.budget;
    }

    public int getClubID() {
        return this.clubID;
    }

    public boolean buy(int price) {

        //TODO checking if operation complete
        return true;
    }


    //this.setMail(mail);
    //this.setBudget();


    private void setClubByID(int id) {
        //TODO
        this.clubID = id;
    }


    public boolean setUserInfo(ResultSet userInfo, String mail) {
        this.mail = mail;
        int size = 0;
        try {
            while (userInfo.next()) {
                this.mail = userInfo.getString("mail");
                this.budget = userInfo.getInt("budget");
                var club_id = userInfo.getInt("club_id");
                this.setClubByID(club_id);
                size += 1;
            }
            if (size == 1) return true;
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static public boolean addNewUser(int id, String login, String password, String mail, int budget, int club_id) {
        DatabaseController dbController = new DatabaseController();

        //TODO checking if operation complete
        return true;
    }

    static public boolean setUserInfoFromDB(User usr, String mail) {
        String query = "SELECT * FROM users WHERE mail = ?";
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstatement = connection.prepareStatement(query);
             ) {
            pstatement.setString(1, mail);
            ResultSet result = pstatement.executeQuery();
            if (usr.setUserInfo(result, mail)) {
                return true;
            }
            else return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




//    public static boolean userExist(String usrMail) {
//        String query = "SELECT * FROM users WHERE mail = ?";
//        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
//             PreparedStatement pstatement = connection.prepareStatement(query);
//        ) {
//            pstatement.setString(1, mail);
//            ResultSet result = pstatement.executeQuery();
//            usr.setUserInfo(result, mail);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
