package com.example.model.entities;

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

}
