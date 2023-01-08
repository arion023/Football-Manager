package com.example.controller.database;

import com.example.model.Club;
import com.example.model.Player;
import com.example.model.Statistics;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.Collections;
import java.util.List;

import static com.example.controller.database.DatabaseConfig.*;

@Repository
public class DatabaseController {


    public String createSelectQuery(String table) {
        return createSelectQuery(List.of(table));
    }

    public String createSelectQuery(List<String> tables) {
        return createSelectQuery(List.of("*"), tables);
    }

    public String createSelectQuery(List<String> fields, List<String> tables) {
        return createSelectQuery(fields, tables, Collections.emptyList());
    }

    public String createSelectQuery(List<String> fields, List<String> tables, List<String> conditions) {
        String query = SELECT + " " + String.join(", ", fields) + " " +
                FROM + " " + String.join(", ", tables) + " ";
        if (conditions.isEmpty()) {
            query.concat(WHERE + " " + String.join(" and ", conditions));
        }
        return query;
    }


    public List<Player> getPlayersFromDB(String query) throws Exception {
        List<Player> players;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query + "FETCH FIRST 20 ROWS ONLY")){;
            players = Player.resultSetToType(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e); //TODO new custom exception
        }
        for(Player p : players){
            String statistics_query = "SELECT * FROM " + STATISTICS_TABLE_NAME + " WHERE player_id =" + p.getId();
            List<Statistics> stats = this.getStatisticsFromDB(statistics_query);
            try {
                if (stats.size() == 1) {
                    p.setStatistics(stats.get(0));
                } else
                    throw new Exception("Too many statistics for one player");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return players;
        }



    public List<Club> getClubsFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Club.resultSetToType(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Statistics> getStatisticsFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Statistics.resultSetToType(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}


