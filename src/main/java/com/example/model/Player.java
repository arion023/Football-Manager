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

    public static List<Player> getAllPlayersFromDB() {
        DatabaseController dbController = new DatabaseController();
        String query = dbController.createSelectQuery(DatabaseConfig.PLAYERS_TABLE_NAME);
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(query)) {
            return resultSetToPlayers(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ArrayList<Player> getAllPlayersFromClub(int clubId) {
        String query = "SELECT * FROM player WHERE club_id =?";
        try (Connection connection = DriverManager.getConnection(DatabaseConfig.URL, DatabaseConfig.USER, DatabaseConfig.PASSWORD);
             PreparedStatement pstatement = connection.prepareStatement(query)) {
            pstatement.setInt(1, clubId);
            ResultSet result = pstatement.executeQuery();
            return resultSetToPlayers(result);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Player> resultSetToPlayers(ResultSet result) {
        ArrayList<Player> players = new ArrayList<>();
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

                Player player = new Player(id, name, surname, birthDate.toLocalDate(), null, null, null, null, positionEnum);
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
