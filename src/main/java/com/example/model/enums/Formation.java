package com.example.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Formation {

    F_343("3-4-3", 3, 4, 3),
    F_352("3-5-2", 3, 5, 2),
    F_442("4-4-2", 4, 4, 2),
    F_433("4-3-3", 4, 3, 3),
    F_451("4-5-1", 4, 5, 1),
    F_532("5-3-2", 5, 3, 2),
    F_541("5-4-1", 5, 4, 1),
    ;
    private final String name;
    private final int defendersNumber;
    private final int midfieldersNumber;
    private final int forwardsNumber;

}
