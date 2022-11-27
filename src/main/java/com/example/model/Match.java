package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class Match {
    private int id;
    private Club homeTeam;
    private Club awayTeam;
    private LocalDate date;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private MatchResult result;
    private Stadium stadium;
    private Referee referee;

    enum MatchResult {
        HOME_TEAM_WON,
        AWAY_TEAM_WON,
        DRAW
    }
}
