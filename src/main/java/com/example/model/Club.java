package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Club {
    private int id;
    private List<Player> players;
    private Statistics overallStatistics;
    private int budget;
    private Coach coach;
    private List<League> leagues;
    private Stadium stadium;
    private List<Match> matchesPlayed;
    private List<Trophy> trophies;

    public static Club getClubById(int clubId) {
        return new Club();
    }
}
