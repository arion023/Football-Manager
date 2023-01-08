package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.error.Mark;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class User {

    private String mail;
    private int budget;
    private int clubID;
    private Club club = new Club(101, "Korona Kielce", null, 250, null, 1, null, null);
    private List<MarketOffer> offers;
    private List<MarketOffer> userOffers;
    private int nextOpponentClubId;
    private String nextOpponentClubName;
    private ArrayList<Player> firstSquad = new ArrayList<>();
    private ArrayList<Player> substitutes = new ArrayList<>();//Must be mutable list i.e ArrayList
    private DatabaseController dbController;

    @Autowired
    public User(DatabaseController dbController) {
        this.dbController = dbController;
        this.offers = MarketOffer.getOffers(this.dbController);
        this.userOffers = new ArrayList<>();
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
            return size == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addNewUser(int id, String login, String password, String mail, int budget, int club_id) {
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


    public List<Player> getAllPlayers() {
        List<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(this.getFirstSquad());
        allPlayers.addAll(this.getSubstitutes());
        return allPlayers;
    }


    public void buyPlayer(MarketOffer offer) {
        //TODO UPDATE DATABASE
        this.offers.remove(offer);
        this.userOffers.remove(offer);
        this.budget -= offer.getPrice();

        addPlayer(offer.getPlayer());
    }

    private void addPlayer(Player player) {
        this.substitutes.add(player);

    }

    public void sellPlayer(Player player) {
        //TODO UPDATE DATABASE
        this.userOffers.add(new MarketOffer(player, player.estimatePrice()));
        this.firstSquad.remove(player);
        this.substitutes.remove(player);

    }

    public List<MarketOffer> getAllOffers(){
        List<MarketOffer> all = new ArrayList<>();
        all.addAll(this.offers);
        all.addAll(this.userOffers);
        return all;
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
