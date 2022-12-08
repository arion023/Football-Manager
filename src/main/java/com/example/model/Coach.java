package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class Coach extends Person {
    private Club currentClub;
    private List<Club> clubsHistory;

    public Coach(int id, String name, String surname, LocalDate birthDate, Country country,
                 Club currentClub, List<Club> clubsHistory) {
        super(id, name, surname, birthDate, country);
        this.currentClub = currentClub;
        this.clubsHistory = clubsHistory;
    }
}
