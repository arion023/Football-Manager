package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Club {
    private int id;
    private String name;
    private List<Player> players;
    private Statistics overallStatistics;
    private int budget;
    private Coach coach;
    private List<League> leagues;
    private Stadium stadium;
    private List<Match> matchesPlayed;
    private List<Trophy> trophies;

    public static Club getClubById(int clubId) {
        DatabaseController dbController = new DatabaseController();
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.CLUBS_TABLE_NAME), List.of("club_id = " + clubId));
        ResultSet resultSet = dbController.doQuery(query);
        return resultSetToClubs(resultSet).get(0); //TODO check if club is present
    }

    private static List<Club> resultSetToClubs(ResultSet result) {
        List<Club> clubs = new ArrayList<>();
        try {

            while (result.next()) {
                var id = result.getInt("id");
                var budget = result.getInt("budget");

                Club club = new Club(1, "Klub", null, null, 0,
                        null, null, null, null, null); //TODO sql
                clubs.add(club);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);//TODO handle exception
        }

        return clubs;
    }
}
