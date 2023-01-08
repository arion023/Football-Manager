package com.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Person {
    protected int id;
    protected String name;
    protected String surname;
    protected LocalDate birthDate;
    protected String countryId;

}
