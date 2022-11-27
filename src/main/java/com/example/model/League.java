package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class League {
    private int id;
    private String name;
    private Country country;
    private List<Club> clubs;
    private Standings standings;
}
