package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
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
public class Statistics {
    private int overall;
    private int pace;
    private int shooting;
    private int passing;
    private int dribbling;
    private int defence;
    private int physically;


    public static Statistics getStatisticsById(int playerId, DatabaseController dbController) {
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.STATISTICS_TABLE_NAME), List.of("player_id = " + playerId));
        List<Statistics> stats = dbController.getStatisticsFromDB(query);
        if (stats.size() == 1)
            return stats.get(0);
        else
            return null;
    }

    public static List<Statistics> resultSetToType(ResultSet rs) {
        List<Statistics> stats = new ArrayList<>();
        try {
            while (rs.next()) {
                var overall = rs.getInt("overall");
                var pace = rs.getInt("pace");
                var shooting = rs.getInt("shooting");
                var passing = rs.getInt("passing");
                var dribbling = rs.getInt("dribbling");
                var defence = rs.getInt("defence");
                var physically = rs.getInt("physical");
                stats.add(new Statistics(overall, pace, shooting, passing, dribbling, defence, physically));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e); //TODO Dedicated exception
        }
        return stats;
    }
}
