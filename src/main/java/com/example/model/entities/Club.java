package com.example.model.entities;

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
    private League leagues;
    private int currentPoints;
    private int goalsScored;
    private int goalsConceded;
    private int currentPosition;
    private Stadium stadium;
    private List<Trophy> trophies;


    public static List<Club> resultSetToClubs(ResultSet result) {
        List<Club> clubs = new ArrayList<>();
        try {
            while (result.next()) {
                var clubId = result.getInt("club_id");
                var name = result.getString("name");
                var budget = result.getInt("budget");

                Club club = new Club(clubId, name, null, budget,
                        null, 0, 0, 0, 0, null, null);//TODO get proper data
                clubs.add(club);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);//TODO handle exception
        }

        return clubs;
    }
}
