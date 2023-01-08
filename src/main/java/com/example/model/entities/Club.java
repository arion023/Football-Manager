package com.example.model.entities;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Club {
    private int id;
    private String name;
    private Statistics overallStatistics;
    private int budget;
    private List<League> leagues;
    private int currentPosition;
    private Stadium stadium;
    private List<Trophy> trophies;


    public static int getPoints() {
        //TODO point counter
        return 0;
    }

    public static Club getClubById(int clubId, DatabaseController dbController) {
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.CLUBS_TABLE_NAME), List.of("club_id = " + clubId));
        List<Club> clubs = dbController.getClubsFromDB(query);
        if (clubs.size() == 1)
            return clubs.get(0);
        else return null;
    }

    public static List<Club> getClubsByLeague(int leagueId, DatabaseController dbController) {
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.CLUBS_TABLE_NAME), List.of("league_id = " + leagueId));
        return dbController.getClubsFromDB(query);
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

    public static List<Club> resultSetToClubs(ResultSet result) {
        List<Club> clubs = new ArrayList<>();
        try {
            while (result.next()) {
                var clubId = result.getInt("club_id");
                var name = result.getString("name");
                var budget = result.getInt("budget");

                Club club = new Club(clubId, name, null, budget,
                        null, 0, null, null);//TODO get proper data
                clubs.add(club);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);//TODO handle exception
        }

        return clubs;
    }
}
