package com.example.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@AllArgsConstructor
public class Statistics {
    private int overall;
    private int pace;
    private int shooting;
    private int passing;
    private int dribbling;
    private int defence;
    private int physically;


    public static Statistics resultSetToType(ResultSet rs) {
        try {
                var overall = rs.getInt("overall");
                var pace = rs.getInt("pace");
                var shooting = rs.getInt("shooting");
                var passing = rs.getInt("passing");
                var dribbling = rs.getInt("dribbling");
                var defence = rs.getInt("defence");
                var physically = rs.getInt("physical");
                return new Statistics(overall, pace, shooting, passing, dribbling, defence, physically);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
