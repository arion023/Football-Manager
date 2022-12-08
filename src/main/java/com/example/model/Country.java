package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Country {
    private int id;
    private String name;
    private String shortName;

    public static Country getCountryById(int countryId) {
        return new Country();
    }
}
