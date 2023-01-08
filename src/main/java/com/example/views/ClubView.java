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
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.time.LocalDate;
import java.util.List;

@Route(value = "/club", layout = AppLayoutBasic.class)
@PageTitle("Club")
@PermitAll
public class ClubView extends HorizontalLayout {

    private final transient User user;
    private final transient Fixtures fixtures;

    private final List<Club> leagueClubs = Club.getAllClubsFromDB();

    Stadium stadium = new Stadium(1, "Stadion Radomiaka", new Address(1, "Struga", 63, "Radom", new Country(1, "Polska", "POL")), 15000, LocalDate.of(1930, 8, 9));

    @Autowired
    public ClubView(User user, Fixtures fixtures) {
        this.user = user;
        this.fixtures = fixtures;
        setDefaultVerticalComponentAlignment(Alignment.AUTO);
        add(clubInformation(), matchTable());

    }

    private VerticalLayout clubInformation() {
        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        infoLayout.add(new H2(user.getClub().getName()));
        infoLayout.add(new Paragraph("Budget: " + user.getClub().getBudget() + " zl"));
        infoLayout.add(detailsLayout());
        return infoLayout;
    }

    private VerticalLayout matchTable() {
        VerticalLayout matchLayout = new VerticalLayout();
        matchLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        matchLayout.add(nextMatch(), leagueTable());
        return matchLayout;
    }


    private HorizontalLayout nextMatch() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        int opponentId = fixtures.getMatchweekToFixtures().get(1).get(user.getClub().getId());
        user.setNextOpponentClubId(opponentId);
        String opponentTeamName = leagueClubs.stream().filter(club -> club.getId() == opponentId).findFirst().get().getName();
        user.setNextOpponentClubName(opponentTeamName);

        Image homeTeamLogo = new Image("images/user_club_logo.png", "user_club_logo");
        homeTeamLogo.setHeight(150, Unit.PIXELS);
        homeTeamLogo.setWidth(150, Unit.PIXELS);


        Span info = new Span(user.getClub().getName() + " - " + opponentTeamName); // TODO link opposition club
        info.setHeight(50, Unit.PIXELS);
        info.getStyle().set("font-size", "1.5rem");
        info.getStyle().set("font-weight", "bold");

        // TODO link opposition club
        Image awayTeamLogo = new Image("images/rakow.png", "raków");
        awayTeamLogo.setHeight(150, Unit.PIXELS);
        awayTeamLogo.setWidth(150, Unit.PIXELS);

        RouterLink gameplayLink = new RouterLink(GameplayView.class);
        Button playButton = new Button("Play match");
        gameplayLink.add(playButton);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(info, gameplayLink);
        verticalLayout.setAlignItems(Alignment.CENTER);

        horizontalLayout.add(homeTeamLogo, verticalLayout, awayTeamLogo);
        return horizontalLayout;
    }

    private Grid<Club> leagueTable() {
        Grid<Club> grid = new Grid<>(Club.class, false);
        grid.addColumn(Club::getName).setHeader("Club:");
        grid.addColumn(c -> c.getPoints()).setHeader("Points:").setSortable(true);

        leagueClubs.add(user.getClub());
        grid.setItems(leagueClubs);
        grid.setHeight(710, Unit.PIXELS);
        return grid;
    }

    private Details detailsLayout() {
        Span stadium = new Span("Stadium: " + "Suzuki Arena " + ", " + "Ściegiennego 8, Kielce");
        Span capacity = new Span("Capacity: " + 15000);
        // TODO trophies list
        VerticalLayout content = new VerticalLayout();
        content.add(stadium);
        content.add(capacity);
        Details details = new Details("Details:", content);
        details.setOpened(false);

        return details;
    }

}
