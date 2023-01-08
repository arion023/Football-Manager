package com.example.model.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class MatchEvent {

    private int id;
    private EventType type;
    private Player player;
    private int occurMinute;


    enum EventType{
        GOAL,
        YELLOW_CARD,
        RED_CARD
    }

}
