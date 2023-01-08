package com.example.model.entities;

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

    public Coach(int id, String name, String surname, LocalDate birthDate, String countryId,
                 Club currentClub, List<Club> clubsHistory) {
        super(id, name, surname, birthDate, countryId);
        this.currentClub = currentClub;
        this.clubsHistory = clubsHistory;
    }
}
