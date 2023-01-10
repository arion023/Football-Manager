package com.example.model.entities;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import com.example.model.enums.Position;
import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.time.LocalDate;
import java.util.*;

import static java.lang.Math.pow;

@Getter
@Setter
public class Player extends Person {

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



    public String getFullName() {
        return super.getName() + " " + super.getSurname();
    }

    public int estimatePrice() {
        //TODO IT CAN BE BETTER...
        if (this.statistics != null) {
            int overall = this.statistics.getOverall();
            return  (int) pow(overall / 10.0, 2) * 1000;
        } else return 0;
    }

    public static List<Player> getAllPlayersFromDB(DatabaseController dbController) {
        //String query = dbController.createSelectQuery(List.of(DatabaseConfig.PLAYERS_TABLE_NAME));
        String query = "SELECT * FROM " + DatabaseConfig.PLAYERS_TABLE_NAME + " INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id)";
        try {
            return dbController.getPlayersFromDB(query);
        } catch (Exception e) {
            return Collections.emptyList(); //TODO
        }
    }

    public static List<Player> getAllPlayersFromClubWithStats(int clubId, DatabaseController dbController) {
        String query = "SELECT * FROM " + DatabaseConfig.PLAYERS_TABLE_NAME + " INNER JOIN " + DatabaseConfig.STATISTICS_TABLE_NAME + " USING (player_id) WHERE club_id = " + clubId;
        try {
            return dbController.getPlayersFromDB(query);
        } catch (Exception e) {
            return Collections.emptyList(); //TODO
        }
    }

    public static List<Player> getPlayersByClub(int clubId, DatabaseController dbController) {
        String query = dbController.createSelectQuery(List.of("*"), List.of(DatabaseConfig.PLAYERS_TABLE_NAME), List.of("club_id = " + clubId));
        try {
            return dbController.getPlayersFromDB(query);
        } catch (Exception e) {
            return Collections.emptyList(); //TODO
        }
    }

    public static ArrayList<Player> resultSetToType(ResultSet result) {
        ArrayList<Player> players = new ArrayList<>();
        try {
            while (result.next()) {
                var id = result.getInt("player_id");
                var name = result.getString("name");
                var surname = result.getString("surname");
                var birthDate = result.getDate("birth_date");
                var countryId = result.getString("country_id");
                var clubId = result.getInt("club_id");
                var position = result.getString("position_id");

                Position positionEnum = getPositionEnum(position);

                Player player;
                try {
                    result.findColumn("overall");
                    player = new Player(id, name, surname, birthDate.toLocalDate(), countryId, clubId, Statistics.resultSetToType(result), positionEnum);
                } catch (SQLException e) {
                    player = new Player(id, name, surname, birthDate.toLocalDate(), countryId, clubId, null, positionEnum);
                }
                players.add(player);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e); //TODO Dedicated exception
        }

        return players;
    }


    public static Position getPositionEnum(String position) {
        var positions = Position.values();//TODO chyba powinna być wybrana jakoś ta pozycja na podstawie stringa a nie losowo
        int index = new Random().nextInt(positions.length);
        return positions[index];
    }



}
