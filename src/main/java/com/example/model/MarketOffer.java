package com.example.model;

import com.example.controller.database.DatabaseController;
import com.example.model.entities.Player;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Getter
@Setter
@RequiredArgsConstructor
public class MarketOffer {
    public static final int OFFERS_LIMIT = 40;
    private Player player;
    private int price;

    public MarketOffer(Player player, int price) {
        this.player = player;
        this.price = price;

    }

    public static List<MarketOffer> getOffers(DatabaseController dbController) {
        //TODO DO MORE REALISTIC  MAYBE??? (DONT ADD PLAYERS FROM USER CLUB)
        List<MarketOffer> offers = new ArrayList<>();
        List<Player> allPlayers = dbController.getAllPlayersFromDB();
        Collections.shuffle(allPlayers);

        List<Player> playersForSell = allPlayers.subList(0, MarketOffer.OFFERS_LIMIT);
        for (Player player : playersForSell) {
            offers.add(new MarketOffer(player, player.estimatePrice()));
        }

        return offers;
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

}