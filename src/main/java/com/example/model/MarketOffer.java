package com.example.model;

import com.example.model.entities.Player;
import com.example.model.entities.Statistics;
import com.example.model.enums.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class MarketOffer {
    public static final int OFFERS_LIMIT = 40;
    private int id;
    private Player player;
    private String clubName;
    private int price;

    public MarketOffer(Player player, int price) {
        this.player = player;
        this.price = price;

    }

    public MarketOffer(int id, Player player, int price) {
        this.id = id;
        this.player = player;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return player.getName();
    }

    public String getSurname() {
        return player.getSurname();
    }

    public String getNationality() {
        if (player.getCountryId() != null)
            return player.getCountryId();
        else return "EMPTY";
    }

    public String getPosition() {
        if (player.getPosition() != null)
            return player.getPosition().getPositionName();
        else return "EMPTY";
    }

    public int getOverall() {
        if (player.getStatistics() != null)
            return player.getStatistics().getOverall();
        else return 0;
    }

    public int getSellerId() {
        return player.getCurrentClubId();
    }

    public static List<MarketOffer> resultSetToMarketOffer(ResultSet rs) {
        List<MarketOffer> offers = new ArrayList<>();
        try {
            while (rs.next()) {
                int offerId = rs.getInt("offer_id");
                int playerId = rs.getInt("player_id");
                int price = rs.getInt("price");

                String name = rs.getString("player_name");
                String surname = rs.getString("surname");
                var birthDate = rs.getDate("birth_date");
                String countryId = rs.getString("player_country_id");
                int clubId = rs.getInt("club_id");
                String clubName = rs.getString("club_name");
                int positionId = rs.getInt("position_id");

                Position positionEnum = Position.getPositionById(positionId);

                Player player;
                try {
                    rs.findColumn("overall");
                    player = new Player(playerId, name, surname, birthDate.toLocalDate(), countryId, clubId, Statistics.resultSetToType(rs), positionEnum);
                } catch (SQLException e) {
                    player = new Player(playerId, name, surname, birthDate.toLocalDate(), countryId, clubId, null, positionEnum);
                }
                MarketOffer mo = new MarketOffer(offerId, player, price);
                mo.setClubName(clubName);
                offers.add(mo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return offers;
    }

}