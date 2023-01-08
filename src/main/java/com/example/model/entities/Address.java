package com.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Address {
    private int id;
    private String street;
    private int number;
    private String city;
    private Country country;

    public String getAddressString() {
        return city + ", " + street + " " + number;
    }
}
