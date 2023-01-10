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
        this.offers = MarketOffer.getOffers(this.dbController);
        this.userOffers = new ArrayList<>();
        //TODO
        //String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));
    }


    public int getBudget() {
        return this.budget;
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
        //TODO AUTOGENERETING ID AS TRIGGER IN DB (ACTUALLY HARDCODED)
        String newClubCommand = "INSERT INTO user_club VALUES ( 349, '" + clubName + "', DEFAULT, DEFAULT, NULL )";
        String newUserCommand = "INSERT INTO users VALUES ( 101, '" + mail + "', '" + nickname + "', DEFAULT, 349, NULL )";
        dbController.updateDatabase(newClubCommand);
        dbController.updateDatabase(newUserCommand);
        return true;
    }

    public static boolean setUserBasicAndClubFromDB(User usr, String mail) {
        //TODO MOVE ADDING CLUB TO OTHER FUN
        String query = "SELECT * FROM users INNER JOIN USER_CLUB USING (club_id) WHERE mail = ?";
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
