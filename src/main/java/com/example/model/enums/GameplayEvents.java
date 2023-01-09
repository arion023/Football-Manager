package com.example.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Random;

@Getter
@RequiredArgsConstructor
public enum GameplayEvents {

    GOAL("GOAL FOR %s!"),

    PASS("%s passes ball to %s"),

    SHOT("What a shot by %s"),

    CLEAR("%s clears"),

    SAVE("Brilliant save by %s!"),

    CORNER("%s win the corner"),

    THROW_IN("%s moves across to take the throw in"),

    DIRECT_FREE_KICK("Direct free kick for %s"),

    INDIRECT_FREE_KICK("Indirect free kick for %s"),

    OFFSIDE("%s was on offside"),

    PENALTY("Referee whistles and it is penalty!"),

    YELLOW_CAR("Yellow card for %s"),

    RED_CARD("Red card for %s"),
    ;

    private static final Random random = new Random();
    private final String description;

    public static GameplayEvents getRandomEvent() {
        var allValues = List.of(GameplayEvents.values());
        return allValues.get(random.nextInt(allValues.size()));
    }

    public static int getTeam() {
        return random.nextInt(2);
    }

    public static int getPlayerIndex() {
        return random.nextInt(11);
    }
}
