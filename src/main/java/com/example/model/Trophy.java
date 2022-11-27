package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class Trophy {
    private int id;
    private int name;
    private League league;
    private LocalDate date;
}
