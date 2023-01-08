package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import com.vaadin.flow.component.html.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
public class Club {
    private int id;
    private String name;
//    private List<Player> players;
    private Statistics overallStatistics;
    private int budget;
//    private Coach coach;
    private List<League> leagues;
    private int currentPosition;
    private Stadium stadium;
//    private List<Match> matchesPlayed;
    private List<Trophy> trophies;
    private Image logo;

    public static Club getClubById(int clubId) {
        DatabaseController dbController = new DatabaseController();
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.CLUBS_TABLE_NAME), List.of("club_id = " + clubId));
        ResultSet resultSet = dbController.doQuery(query);
        return resultSetToClubs(resultSet).get(0); //TODO check if club is present
    }

    public static int getPoints() {
//        int points = ;
        int points = 0; //TODO point counter
        return points;
    }

    public static List<Club> getAllClubsFromDB() {
        DatabaseController dbController = new DatabaseController();
        String query = dbController.createSelectQuery(DatabaseConfig.CLUBS_TABLE_NAME);
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {
            return resultSetToClubs(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Club> resultSetToClubs(ResultSet result) {
        List<Club> clubs = new ArrayList<>();
        try {
            while (result.next()) {
                var club_id = result.getInt("club_id");
                var name = result.getString("name");
                var budget = result.getInt("budget");

                Club club = new Club(club_id, name, null, budget,
                         null, 0,null, null, null); //TODO sql
                clubs.add(club);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);//TODO handle exception
        }

        return clubs;
    }
}
