package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Coach extends Person {
    private Club currentClub;
    private List<Club> clubsHistory;

}
