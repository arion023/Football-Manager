package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public abstract class Person {
    protected int id;
    protected String name;
    protected String surname;
    protected LocalDate birthDate;
    protected Country country;

}
