package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Country {
    private String id;
    private String name;

    public static Country getCountryById(String id) {
        return new Country( id, null);
    } //TODO fix return

    public static List<Country> resultSetToType(ResultSet rs){
        List<Country> countries = new ArrayList<>();
        try {
            while (rs.next()) {
                var id = rs.getString("country_id");
                var name = rs.getString("name");
                countries.add(new Country(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return countries;

    }

}
