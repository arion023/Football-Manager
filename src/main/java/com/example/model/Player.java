package com.example.model;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Math.pow;

@Getter
@Setter
public class Player extends Person{

    private int currentClubId;
    private Statistics statistics;
    private Position position;
    public Player(int id, String name, String surname, LocalDate birthDate, String countryId,
                  int currentClubId, Statistics statistics, Position position) {
        super(id, name, surname, birthDate, countryId);
        this.currentClubId = currentClubId;
        this.statistics = statistics;
        this.position = position;
    }

    //    public static List<Player> getAllPlayersFromDB() {
//        DatabaseController dbController = new DatabaseController();
//        String query = dbController.createSelectQuery(DatabaseConfig.PLAYERS_TABLE_NAME);
//        ResultSet resultSet = dbController.doQuery(query);
//        return resultSetToPlayers(resultSet);
//    }


    public String getFullName() {
        String allName = super.getName() + " " + super.getSurname();
        return allName;
    }

    public int estimatePrice() {
        //TODO IT CAN BE BETTER...
        if (this.statistics != null) {
            int overall = this.statistics.getOverall();
            int estimatedPrice = (int) pow(overall/10, 2) * 1000;
            return estimatedPrice;
        }
        else return 0;
    }
    public static List<Player> getAllPlayersFromDB(DatabaseController dbController) {
        String query = dbController.createSelectQuery(List.of(DatabaseConfig.PLAYERS_TABLE_NAME));
        try {
            return dbController.getPlayersFromDB(query);
        } catch (Exception e) {
            return null; //TODO
        }
    }

    public static List<Player> getPlayersByClub(int clubId, DatabaseController dbController) {
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));
        try {
            return dbController.getPlayersFromDB(query);
        } catch (Exception e) {
            return null; //TODO
        }
    }

    public static List<Player> resultSetToType(ResultSet result) {
        List<Player> players = new ArrayList<>();
        Map<Integer, Country> countries = new HashMap<>();
        Map<Integer, Club> clubs = new HashMap<>();
        try {
            while (result.next()) {
                var id = result.getInt("player_id");
                var name = result.getString("name");
                var surname = result.getString("surname");
                var birthDate = result.getDate("birth_date");
                var countryId = result.getString("country_id");
                var clubId = result.getInt("club_id");
                var position = result.getString("position_id");

//                Country country = countries.getOrDefault(countryId, Country.getCountryById(countryId));
//                Club club = clubs.getOrDefault(clubId, Club.getClubById(clubId));
//                List<Club> clubsHistory = getClubsHistory(id);
//                Statistics statistics = Statistics.getStatisticsById(statsId);
                Position positionEnum = getPositionEnum(position);

//                countries.put(countryId, country);
//                clubs.put(clubId, club);

                Player player = new Player(id, name, surname, birthDate.toLocalDate(), countryId, clubId, null, positionEnum);
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
        var positions = Position.values();
        int index = new Random().nextInt(positions.length);
        return positions[index];
    }




    @Getter
    @RequiredArgsConstructor
    public enum Position {
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

        public static List<Position> getGoalkeepersPositions() {
            return List.of(GK);
        }
        public static List<Position> getBackPositions() {
            return List.of(LB, CB, RB);
        }

        public static List<Position> getMidfieldPositions() {
            return List.of(LM, CM, RM);
        }

        public static List<Position> getForwardPositions() {
            return List.of(LF, CF, RF);
        }
    }
}
