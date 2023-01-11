package com.example.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@Getter
@RequiredArgsConstructor
public enum Formation {

    F_343(1, "3-4-3", 3, 4, 3),
    F_352(2, "3-5-2", 3, 5, 2),
    F_442(3, "4-4-2", 4, 4, 2),
    F_433(4, "4-3-3", 4, 3, 3),
    F_451(5, "4-5-1", 4, 5, 1),
    F_532(6, "5-3-2", 5, 3, 2),
    F_541(7, "5-4-1", 5, 4, 1),
    ;
    private final int id;
    private final String name;
    private final int defendersNumber;
    private final int midfieldersNumber;
    private final int forwardsNumber;

    public static Formation getFormationById(int formationId) {
        Optional<Formation> formation = Arrays.stream(Formation.values()).filter(e -> e.getId() == formationId).findFirst();
        return formation.orElse(Formation.F_442);
    }

}
