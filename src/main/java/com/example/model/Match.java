package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Match {
    private int id;
    private Club homeTeam;
    private Club awayTeam;
    private LocalDate date;
    private List<MatchEvent> events;
    private MatchResult result;
    private Stadium stadium;
    private Referee referee;

    enum MatchResult {
        HOME_TEAM_WON,
        AWAY_TEAM_WON,
        DRAW
    }
}
