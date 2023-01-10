package com.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Stadium {
    private int id;
    private String name;
    private Address address;
    private int capacity;
    private LocalDate buildDate;

}
