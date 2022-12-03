package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Country {
    private int id;
    private String name;
    private String shortName;

    public static Country getCountryById(int countryId) {
        return new Country(1, null, null);
    } //TODO fix return
}
