package com.example.controller.database;

import com.example.model.MarketOffer;
import com.example.model.entities.Club;
import com.example.model.entities.Match;
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

    public String createSelectQuery(List<String> fields, List<String> tables, List<String> conditions) {
        String query = SELECT + " " + String.join(", ", fields) + " " +
                FROM + " " + String.join(", ", tables) + " ";
        if (!conditions.isEmpty()) {
            query = query.concat(WHERE + " " + String.join(" and ", conditions));
        }
        return query;
    }

    public List<Player> getAllPlayersFromDB() {
        String query = "SELECT * FROM " + DatabaseConfig.PLAYERS_TABLE_NAME + " INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id)";
        try {
            return getPlayersFromDB(query);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Player> getAllPlayersFromClubWithStats(int clubId) {
        String query = "SELECT * FROM " + DatabaseConfig.PLAYERS_TABLE_NAME + " INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id) WHERE club_id = " + clubId;
        try {
            return getPlayersFromDB(query);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    public List<Player> getPlayersByClub(int clubId) {
        String query = createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));
        try {
            return getPlayersFromDB(query);
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private List<Player> getPlayersFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Player.resultSetToPlayers(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e); //TODO new custom exception
        }
    }


    public List<Club> getAllClubs() {
        String query = createSelectQuery(List.of("*"), List.of(DatabaseConfig.CLUBS_TABLE_NAME));
        List<Club> clubs = getClubsFromDB(query);
        String getPointsQuery = "SELECT GET_POINTS(%d) FROM DUAL";
        String getScoredGoalsQuery = "SELECT GET_SCORED_GOALS(%d) FROM DUAL";
        String getConcededGoalsQuery = "SELECT GET_CONCEDED_GOALS(%d) FROM DUAL";
        for (var club : clubs) {
            club.setCurrentPoints(callFunction(String.format(getPointsQuery, club.getId())));
            club.setGoalsScored(callFunction(String.format(getScoredGoalsQuery, club.getId())));
            club.setGoalsConceded(callFunction(String.format(getConcededGoalsQuery, club.getId())));
            //TODO load matchweek from db
            //TODO wczytać dane klubu gracza
        }

        return clubs;
    }

    public Club getClubById(int clubId) {
        String query = createSelectQuery(List.of("*"), List.of(DatabaseConfig.CLUBS_TABLE_NAME), List.of("club_id = " + clubId));
        List<Club> clubs = getClubsFromDB(query);
        if (clubs.size() == 1)
            return clubs.get(0);
        else return null;
    }

    public List<Club> getClubsByLeague(int leagueId) {
        String query = createSelectQuery(List.of("*"), List.of(DatabaseConfig.CLUBS_TABLE_NAME), List.of("league_id = " + leagueId));
        return getClubsFromDB(query);
    }

    private List<Club> getClubsFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Club.resultSetToClubs(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Statistics getStatisticsById(int playerId) {
        String query = "SELECT " + DatabaseConfig.STATISTICS_TABLE_NAME + " WHERE player_id = " + playerId;
        return getStatisticsFromDB(query);
    }

    private Statistics getStatisticsFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Statistics.resultSetToType(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MarketOffer> getOffersFromDB(String query) {
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return MarketOffer.resultSetToType(rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Match> getClubMatches(int clubId){
        String query =  "SELECT * FROM " + MATCHES_TABLE_NAME + " WHERE home_club = " + clubId;;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(query)) {
            return Match.resultSetToMatch(rs);
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

    public int getNextId(String idName, String tableName) {
        int maxId = 0;
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(String.format("SELECT MAX(%s) FROM %s", idName, tableName))) {
            while (result.next()) {
                maxId = result.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return maxId + 1;
    }

}


