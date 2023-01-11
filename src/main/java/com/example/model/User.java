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
    private int clubId;
    private int formationId = 3;
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
    }


    public int getBudget() {
        return this.budget;
    }

    public int getClubId() {
        return this.clubId;
    }

    public boolean setUserBasicsInfo(ResultSet userInfo) {
        // setting user id, mail, nickname, budget, formation, club_id
        int size = 0;
        try {
            while (userInfo.next()) {
                this.id = userInfo.getInt("user_id");
                this.mail = userInfo.getString("mail");
                this.nickname = userInfo.getString("nickname");
                this.budget = userInfo.getInt("budget");
                this.formationId = userInfo.getInt("formation_id");
                try {
                    this.clubId = userInfo.getInt("club_id");
                    String clubName = userInfo.getString("name");
                    this.club = new Club(clubId, clubName);
                } catch (SQLException e) {
                    throw new SQLException("Club of user not found");
                }
                size += 1;
            }
            return size == 1;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addNewUserToDB(String mail, String nickname, String clubName) {
        int nextClubId = dbController.getNextUserClubId("CLUB_ID", "CLUB");
        String newClubCommand = "INSERT INTO club VALUES (" + nextClubId + ", '" + clubName + "', DEFAULT, DEFAULT, NULL )";
        String newUserCommand = "INSERT INTO users VALUES (DEFAULT, '" + mail + "', '" + nickname + "', DEFAULT," + nextClubId + ", NULL )";
        dbController.updateDatabase(newClubCommand);
        dbController.updateDatabase(newUserCommand);
        return true;
    }

    public void setUserOffersFromDB() {
        String myOffers = "SELECT * FROM " + DatabaseConfig.OFFER_TABLE_NAME + " INNER JOIN " + DatabaseConfig.PLAYERS_TABLE_NAME + " USING (player_id) INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id) WHERE user_id = " + this.getId() + " AND club_id = " + this.getClubId();
        String restOffers = "SELECT * FROM " + DatabaseConfig.OFFER_TABLE_NAME + " INNER JOIN " + DatabaseConfig.PLAYERS_TABLE_NAME + " USING (player_id) INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id) WHERE user_id = " + this.getId() + " AND club_id != " + this.getClubId();
        this.userOffers = dbController.getOffersFromDB(myOffers);
        this.offers = dbController.getOffersFromDB(restOffers);

    }

    public boolean setUserBasicAndClubFromDB(User usr, String mail) {
        //TODO MOVE ADDING CLUB TO OTHER FUN
        String query = "SELECT * FROM " + DatabaseConfig.USERS_TABLE_NAME + " INNER JOIN " + DatabaseConfig.CLUBS_TABLE_NAME + " USING (club_id) WHERE mail = ?";
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstatement = connection.prepareStatement(query)
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
        if (this.budget - offer.getPrice() > 0) {
            this.removeOffer(offer);
            this.setBudget(this.getBudget() - offer.getPrice());
            this.addPlayer(offer.getPlayer());
            return true;
        } else {
            return false;
        }
    }

    public void setBudget(int budget) {
        this.budget = budget;
        String update = "UPDATE " + DatabaseConfig.USERS_TABLE_NAME + " SET budget = " + this.budget + " WHERE user_id = " + this.getId();
        dbController.updateDatabase(update);
    }

    private void removeOffer(MarketOffer offer) {
        if (offer.getSellerId() == this.getClubId()) {
            this.userOffers.remove(offer);
        } else {
            this.offers.remove(offer);
        }

        if (offer.getId() != 0) {
            String update = "DELETE FROM " + DatabaseConfig.OFFER_TABLE_NAME + " WHERE offer_id = " + offer.getId();
            dbController.updateDatabase(update);
        }
    }

    private void addOffer(MarketOffer offer) {
        if (offer.getSellerId() == this.getClubId()) {
            this.userOffers.add(offer);
        } else {
            this.offers.add(offer);
        }

        String update = "INSERT INTO " + DatabaseConfig.OFFER_TABLE_NAME + " VALUES (DEFAULT, " + this.getId() + ", " + offer.getPlayer().getId() + ", " + offer.getPrice() + " )";
        dbController.updateDatabase(update);
    }

    private void addPlayer(Player player) {
        this.substitutes.add(player);

        String update = "UPDATE " + DatabaseConfig.PLAYERS_TABLE_NAME + " SET club_id = " + this.getClubId() + " WHERE player_id = " + player.getId();
        dbController.updateDatabase(update);

    }

    public void sellPlayer(Player player, int price) {
        //TODO UPDATE DATABASE
        this.addOffer(new MarketOffer(player, price));

    }

    public List<MarketOffer> getAllOffers() {
        List<MarketOffer> all = new ArrayList<>();
        all.addAll(this.offers);
        all.addAll(this.userOffers);
        return all;
    }

    public void clear() {
        this.budget = 0;
        this.firstSquad = new ArrayList<>();
        this.substitutes = new ArrayList<>();
        this.offers = null;
    }
}
