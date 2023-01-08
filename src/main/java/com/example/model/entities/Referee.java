package com.example.model.entities;

import com.example.model.entities.Match;
import com.example.model.entities.Person;
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
