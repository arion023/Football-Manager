package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class Stadium {
    private String name;
    private int id;
    private Address address;
    private int capacity;
    private LocalDate buildDate;

}
