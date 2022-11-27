package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Statistics {
    private int id;
    private int overall;
    private int pace;
    private int shooting;
    private int passing;
    private int dribbling;
    private int defence;
    private int physically;

    public static Statistics getStatisticsById(int statsId) {
        return new Statistics();
    }

}
