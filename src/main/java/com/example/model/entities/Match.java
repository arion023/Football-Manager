package com.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Match {
    private int id;
    private int homeTeamId;
    private int awayTeamId;

    private int homeTeamGoals;
    private int awayTeamGoals;
    private int matchweek;

    public static List<Match> resultSetToMatch(ResultSet rs){
        List<Match> matches = new ArrayList<>();
        try {
            while (rs.next()) {
                int matchId = rs.getInt("match_id");
                int homeClubId = rs.getInt("home_club");
                int awayClubId = rs.getInt("away_club");
                int homeTeamGoals = rs.getInt("home_goals");
                int awayTeamGoals = rs.getInt("away_goals");
                int matchweek = rs.getInt("match_week");

                matches.add(new Match(matchId, homeClubId, awayClubId, homeTeamGoals, awayTeamGoals, matchweek));
            }
        } catch (SQLException e) {
            return matches;
        }
        return matches;
    }

}
