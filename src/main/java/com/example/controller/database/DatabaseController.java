package com.example.controller.database;

import com.example.model.entities.Club;
import com.example.model.entities.Player;
import com.example.model.entities.Statistics;
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

    public String createInsertQuery(String table, List<String> values) {
        String query = "INSERT INTO " + table + " VALUES ( ";
        StringBuilder builder = new StringBuilder();
        for (String v : values) {
            builder.append(v).append(", ");
        }
        query += builder.toString();
        query += ")";
        return query;
    }

    public String createSelectQuery(List<String> fields, List<String> tables, List<String> conditions) { //TODO WORKS?
        String query = SELECT + " " + String.join(", ", fields) + " " +
                FROM + " " + String.join(", ", tables) + " ";
        if (!conditions.isEmpty()) {
            query = query.concat(WHERE + " " + String.join(" and ", conditions));
        }
        return query;
    }


    public List<Player> getPlayersFromDB(String query) throws Exception {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Player.resultSetToType(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e); //TODO new custom exception
        }
    }


    public List<Club> getClubsFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Club.resultSetToClubs(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Statistics getStatisticsFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Statistics.resultSetToType(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //UPDATE; INSERT; DROP; CREATE; DELETE etc
    public void updateDatabase(String command) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(command);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public int callFunction(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return resultSetToFunction(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int resultSetToFunction(ResultSet resultSet) throws SQLException {
        resultSet.next();
        return resultSet.getInt(1);
    }

}


