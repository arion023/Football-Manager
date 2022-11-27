package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Address {
    private int id;
    private String street;
    private int number;
    private String city;
    private Country country;
}
