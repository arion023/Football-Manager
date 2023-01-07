package com.example.views;

import com.example.model.*;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Route(value = "/club", layout = AppLayoutBasic.class)
@PageTitle("Your Club")
@PermitAll
public class ClubView extends HorizontalLayout {
    Stadium stadium = new Stadium(1,"Stadion Radomiaka", new Address(1, "Struga", 63, "Radom", new Country(1, "Polska", "POL")), 15000, LocalDate.of(1930, 8, 9));
    Club club = new Club(1, "RKS Radomiak Radom", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak"));

    public ClubView() {
        setDefaultVerticalComponentAlignment(Alignment.AUTO);
        add(clubInformation());
        add(matchTable());

    }

    private VerticalLayout clubInformation() {
        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.add(new H2(club.getName()));
        infoLayout.add(new Paragraph("Budget: " + club.getBudget() + " zl"));
        infoLayout.add(detailsLayout());
        return infoLayout;
    }

    private VerticalLayout matchTable() {
        VerticalLayout matchLayout = new VerticalLayout();

        matchLayout.add(nextMatch());
        matchLayout.add(leagueTable());
        matchLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        return matchLayout;
    }

    private Grid leagueTable() {
        Grid<Club> grid = new Grid<>(Club.class, false);
        grid.addColumn(Club::getName).setHeader("Club:");
        grid.addColumn(club -> club.getPoints()).setHeader("Points:").setSortable(true);
        List<Club> clubs = getSampleClubs();
        grid.setItems(getSampleClubs());
        grid.setItems(clubs);
        grid.setHeight(710, Unit.PIXELS);
        return grid;
    }


    private HorizontalLayout nextMatch() {

        VerticalLayout verticalLayout = new VerticalLayout();
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        Image clubLogo = club.getLogo();
        clubLogo.setHeight(150, Unit.PIXELS);
        clubLogo.setWidth(150, Unit.PIXELS);

        // TODO link opposition club
        Image rakow = new Image("images/rakow.png", "raków");
        rakow.setHeight(150, Unit.PIXELS);
        rakow.setWidth(150, Unit.PIXELS);

        Span info = new Span(club.getName() + " - " + "RKS Rakow Czestochowa"); // TODO link opposition club

        info.setHeight(50, Unit.PIXELS);
        info.getStyle().set("font-size", "18px");
        info.getStyle().set("font-weight", "bold");

        Button playButton = new Button("Play match");
        verticalLayout.add(info, playButton);
        verticalLayout.setAlignItems(Alignment.CENTER);
        horizontalLayout.add(clubLogo, verticalLayout, rakow);
        return horizontalLayout;
    }

    private Details detailsLayout() {
        Span stadium = new Span("Stadium: " + club.getStadium().getName() + ", " + club.getStadium().getAddress().getAddressString());
        Span capacity = new Span( "Capacity: " + club.getStadium().getCapacity());
        // TODO trophies list
        VerticalLayout content = new VerticalLayout();
        content.add(stadium);
        content.add(capacity);
        Details details = new Details("Details:", content);
        details.setOpened(false);

        return details;
    }

    private List<Club> getSampleClubs() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club(1, "RKS Radomiak Radom", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(2, "Lech Poznań", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(3, "Raków Częstochowa", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(4, "Pogoń Szczecin", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(5, "Lechia Gdańsk", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(6, "Piast Gliwice", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(7, "Wisła Płock", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(8, "Górnik Zabrze", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(9, "Cracovia", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(10, "Legia Warszawa", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(11, "Warta Poznań", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(12, "Jagiellonia Białystok", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(13, "Zagłębie Lubin", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(14, "Stal Mielec", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(15, "Śląsk Wrocław", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(16, "Bruk-Bet Termalica", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(17, "Wisła Kraków", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        clubs.add(new Club(18, "Górnik Łęczna", null, null, 100000000, null, null, stadium, null, null, new Image("images/radomiak.png", "radomiak")));
        return clubs;
    }

}
