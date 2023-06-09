package com.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Country {
    private String id;
    private String name;

    public static List<Country> resultSetToCountry(ResultSet rs){
        List<Country> countries = new ArrayList<>();
        try {
            while (rs.next()) {
                var id = rs.getString("country_id");
                var name = rs.getString("name");
                countries.add(new Country(id, name));
            }
        } catch (SQLException e) {
            return countries;
        }
        return countries;

    }

}
