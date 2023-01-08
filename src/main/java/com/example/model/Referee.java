package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Referee extends Person {
    private List<Match> refereedMatches;
    //    private YellowCard yellowCardsGiven;
    //    private RedCard redCardsGiven;
    //  private int penaltiesGiven;
    //TODO może usunąć całkowicie
}
