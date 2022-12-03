package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Player extends Person {

    private Club currentClub;
    private List<Club> clubsHistory;
    private Statistics statistics;
    private Position position;

    public Player(int id, String name, String surname, LocalDate birthDate, Country country,
                  Club currentClub, List<Club> clubsHistory, Statistics statistics, Position position) {
        super(id, name, surname, birthDate, country);
        this.currentClub = currentClub;
        this.clubsHistory = clubsHistory;
        this.statistics = statistics;
        this.position = position;
    }

    public static List<Player> getAllPlayersFromDB() {
        DatabaseController dbController = new DatabaseController();
        String query = dbController.createSelectQuery(DatabaseConfig.PLAYERS_TABLE_NAME);
        ResultSet resultSet = dbController.doQuery(query);
        return resultSetToPlayers(resultSet);
    }

    public static List<Player> getAllPlayersFromClub(int clubId) {
        DatabaseController dbController = new DatabaseController();
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));
        ResultSet resultSet = dbController.doQuery(query);
        return resultSetToPlayers(resultSet);
    }

    private static List<Player> resultSetToPlayers(ResultSet result) {
        List<Player> players = new ArrayList<>();
        Map<Integer, Country> countries = new HashMap<>();
        Map<Integer, Club> clubs = new HashMap<>();
        try {
            while (result.next()) {
                var id = result.getInt("id");
                var name = result.getString("name");
                var surname = result.getString("surname");
                var birthDate = result.getDate("birth_date");
                var countryId = result.getInt("country_id");
                var clubId = result.getInt("club_id");
                var statsId = result.getInt("statistics_id");
                var position = result.getString("position");

                Country country = countries.getOrDefault(countryId, Country.getCountryById(countryId));
                Club club = clubs.getOrDefault(clubId, Club.getClubById(clubId));
                List<Club> clubsHistory = getClubsHistory(id);
                Statistics statistics = Statistics.getStatisticsById(statsId);
                Position positionEnum = getPositionEnum(position);

                countries.put(countryId, country);
                clubs.put(clubId, club);

                Player player = new Player(id, name, surname, birthDate.toLocalDate(), country, club, clubsHistory, statistics, positionEnum);
                players.add(player);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e); //TODO Dedicated exception
        }

        return players;
    }

    private static List<Club> getClubsHistory(int playerId) {
        return new ArrayList<>();
    }

    private static Position getPositionEnum(String position) {
        return Position.GK;
    }

    @Getter
    @RequiredArgsConstructor
    enum Position {
        GK("Goalkeeper"),
        LB("Left Back"),
        CB("Center Back"),
        RB("Right Back"),
        LM("Left Midfielder"),
        CM("Center Midfielder"),
        RM("Right Midfielder"),
        LF("Left Forward"),
        CF("Center Forward"),
        RF("Right Forward");

        private final String positionName;
    }
}
