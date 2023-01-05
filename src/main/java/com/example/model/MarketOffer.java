package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class MarketOffer {
    private Player player;
    private int price;

    public MarketOffer(Player player, int price){
        this.player = player;
        this.price = price;

    }


    public String getName(){
        return player.getName();
    }

    public String getSurname(){
        return player.getSurname();
    }

    public String getNationality(){
        return player.getCountry().getShortName();
    }

    public String getPosition(){
        return player.getPosition().getPositionName();
    }

    public int getOverall(){
        return player.getStatistics().getOverall();
    }

    public String getSeller(){
        return player.getCurrentClub().getName();
    }

}