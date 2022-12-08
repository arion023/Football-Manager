package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
        String address = city + ", " + street + " " + number;
        return address;
    }
}
