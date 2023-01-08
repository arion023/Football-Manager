package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
//    private LocalDate date;
//    private List<MatchEvent> events;
//    private MatchResult result;
//    private Stadium stadium;
//    private Referee referee;

    enum MatchResult {
        HOME_TEAM_WON,
        AWAY_TEAM_WON,
        DRAW
    }
}
