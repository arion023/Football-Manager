package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import com.vaadin.flow.component.html.Image;
import lombok.AllArgsConstructor;
import lombok.Getter;
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
    private Image logo;


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

    public static int getPoints() {
//        int points = ;
        int points = 0; //TODO point counter
        return points;
    }

    public static List<Club> resultSetToType(ResultSet result) {
        List<Club> clubs = new ArrayList<>();
        try {
            while (result.next()) {
                var name = result.getString("name");
                var id = result.getInt("club_id");
                var budget = result.getInt("budget");

                Club club = new Club(id, name, null, null, budget,
                        null, null, null, null, null, null); //TODO sql
                clubs.add(club);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);//TODO handle exception
        }

        return clubs;
    }

}
