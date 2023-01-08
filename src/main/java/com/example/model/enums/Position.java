package com.example.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public enum Position {
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

    public static List<Position> getGoalkeepersPositions() {
        return List.of(GK);
    }

    public static List<Position> getBackPositions() {
        return List.of(LB, CB, RB);
    }

    public static List<Position> getMidfieldPositions() {
        return List.of(LM, CM, RM);
    }

    public static List<Position> getForwardPositions() {
        return List.of(LF, CF, RF);
    }
}

