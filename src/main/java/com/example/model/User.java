package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import com.example.model.entities.Club;
import com.example.model.entities.Player;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;

@Component
@Getter
@Setter
public class User {

    private String mail;
    private int budget;
    private int clubID;
    private Club club = new Club(101, "Korona Kielce", null, 250, null, 1, null, null);

    private int nextOpponentClubId;
    private String nextOpponentClubName;
    private ArrayList<Player> firstSquad = new ArrayList<>();
    private ArrayList<Player> substitutes = new ArrayList<>();//Must be mutable list i.e ArrayList

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
                var clubId = userInfo.getInt("club_id");
                this.setClubByID(clubId);
                size += 1;
            }
            return size == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addNewUser(int id, String login, String password, String mail, int budget, int clubId) {
        DatabaseController dbController = new DatabaseController();

        //TODO checking if operation complete
        return true;
    }

    public static boolean setUserInfoFromDB(User usr, String mail) {
        String query = "SELECT * FROM users WHERE mail = ?";
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstatement = connection.prepareStatement(query);
        ) {
            pstatement.setString(1, mail);
            ResultSet result = pstatement.executeQuery();

            return usr.setUserInfo(result, mail);
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
