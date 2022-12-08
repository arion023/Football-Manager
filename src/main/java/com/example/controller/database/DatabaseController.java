package com.example.controller.database;

import java.sql.*;
import java.util.Collections;
import java.util.List;

import static com.example.controller.database.DatabaseConfig.*;

public class DatabaseController {
//    public void connect() {
//        try {
//            Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
//            Statement statement = connection.createStatement();
//            String query = "SELECT * FROM TEST_Z04";
//            ResultSet result = statement.executeQuery(query);
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public ResultSet doQuery(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {
            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

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
        query.concat(" FETCH FIRST 50 ROWS ONLY");
        return query;
    }
}
