package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Player extends Person {

    private Club currentClub;
    private List<Club> clubsHistory;
    private Statistics statistics;
    private Position position;

    //    private YellowCard yellowCards;
//    private RedCard redCards;
//    private int goalsInLastSeason;
    @Getter
    @RequiredArgsConstructor
    enum Position {
        GK("Goalkeeper"),
        LB("Left Back"),
        CB("Center Back"),
        RB("Right Back"),
        LM("Left Midfielder"),
        CM("Center Midfielder"),
        RM("Right Midfielder"),
        LF("Left Forward"),
        CF("Center Forward"),
        RF("Right Forward");

        private final String positionName;
    }
}
