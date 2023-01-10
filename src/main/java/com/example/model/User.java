package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import com.example.model.entities.Club;
import com.example.model.entities.Player;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@Setter
public class User {

    private int id;
    private String mail;
    private String nickname;
    private int budget;
    private int clubID;
    private int formationID; //TODO CHANGE ON FORMATION

    private Club club;
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



    public boolean setUserBasicsInfo(ResultSet userInfo) {
        // setting user id, mail, nickname, budget, formation, club_id
        int size = 0;
        try {
            while (userInfo.next()) {
                this.id = userInfo.getInt("user_id");
                this.mail = userInfo.getString("mail");
                this.nickname = userInfo.getString("nickname");
                this.budget = userInfo.getInt("budget");
                this.formationID = userInfo.getInt("formation_id");
                try {
                    this.clubID = userInfo.getInt("club_id");
                    String clubName = userInfo.getString("name");
                    String countryID = userInfo.getString("country_id");
                    int leagueID = userInfo.getInt("league_id");
                    int stadiumID = userInfo.getInt("stadium_id");
                    //TODO REPAIR CONSTRUCTOR TO ONLY NEEDED DATA
                    this.club = new Club(clubID, clubName, null, 1000, null, 0, null, null);
                } catch (SQLException e) {
                    throw new SQLException("Club of user not found"); //TODO SPECIAL EXCEPTION AND ERROR
                }
                size += 1;
            }
            return size == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean addNewUserToDB(String mail, String nickname, String clubName, DatabaseController dbController) {
        //TODO AUTOGENERETING ID AS TRIGGER IN DB (ACTUALLY HARDCODED) ID DEFAULT (maybe function adding player and creating new club)
        String newClubCommand = "INSERT INTO user_club VALUES ( 349, '" + clubName + "', DEFAULT, DEFAULT, NULL )";
        String newUserCommand = "INSERT INTO users VALUES ( 101, '" + mail + "', '" + nickname + "', DEFAULT, 349, NULL )";
        dbController.updateDatabase(newClubCommand);
        dbController.updateDatabase(newUserCommand);
        return true;
    }

    public void setUserOffersFromDB(){
        String myOffers = "SELECT * FROM " + DatabaseConfig.OFFER_TABLE_NAME + " INNER JOIN " + DatabaseConfig.PLAYERS_TABLE_NAME  + " USING (player_id) INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id) WHERE user_id = " + this.getId() + " AND club_id = " + this.getClubID();
        String restOffers = "SELECT * FROM " + DatabaseConfig.OFFER_TABLE_NAME + " INNER JOIN " + DatabaseConfig.PLAYERS_TABLE_NAME  + " USING (player_id) INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id) WHERE user_id = " + this.getId() + " AND club_id != " + this.getClubID();
        this.userOffers = dbController.getOffersFromDB(myOffers);
        this.offers = dbController.getOffersFromDB(restOffers);

    }

    public static boolean setUserBasicAndClubFromDB(User usr, String mail) {
        //TODO MOVE ADDING CLUB TO OTHER FUN
        String query = "SELECT * FROM " + DatabaseConfig.USERS_TABLE_NAME + " INNEJ JOIN " + DatabaseConfig.CLUBS_TABLE_NAME + " USING (club_id) WHERE mail = ?";
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstatement = connection.prepareStatement(query);
        ) {
            pstatement.setString(1, mail);
            ResultSet result = pstatement.executeQuery();

            return usr.setUserBasicsInfo(result);
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


    public boolean buyPlayer(MarketOffer offer) {
        //TODO UPDATE DATABASE

        if ( this.budget - offer.getPrice() > 0)
        {
            this.removeOffer(offer);
            this.budget -= offer.getPrice();
            this.addPlayer(offer.getPlayer());
            return true;
        } else { return false; }
    }

    private void removeOffer(MarketOffer offer) {
        if (offer.getSellerId() == this.getClubID()){
            this.userOffers.remove(offer);
        } else { this.offers.remove(offer); }

        if (offer.getId() != 0) {
            String update = "DELETE FROM " + DatabaseConfig.OFFER_TABLE_NAME + " WHERE offer_id = " + offer.getId();
            dbController.updateDatabase(update);
        }
    }

    private void addOffer(MarketOffer offer) {
        if (offer.getSellerId() == this.getClubID()){
            this.userOffers.add(offer);
        } else {
            this.offers.add(offer); }

        //TODO CHANGE ID SETTING ON DEFAULT
        String update = "INSERT INTO " + DatabaseConfig.OFFER_TABLE_NAME + " VALUES ( 10, " + this.getId() + ", " + offer.getPlayer().getId() + ", " + offer.getPrice() + " )";
        dbController.updateDatabase(update);
        }

    private void addPlayer(Player player) {
        this.substitutes.add(player);

        String update = "UPDATE " + DatabaseConfig.PLAYERS_TABLE_NAME + " SET club_id = " + this.getClubID() + " WHERE player_id = " + player.getId();
        dbController.updateDatabase(update);

    }

    public void sellPlayer(Player player, int price) {
        //TODO UPDATE DATABASE
        this.addOffer(new MarketOffer(player, price));
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
