package com.example.views;

import com.example.controller.database.DatabaseController;
import com.example.model.entities.Club;
import com.example.model.entities.Match;
import com.example.model.enums.ClubLogo;
import com.example.model.Fixtures;
import com.example.model.User;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;

import static com.example.model.utils.CssValues.CSS_FONT_SIZE;

@Route(value = "/club", layout = AppLayoutBasic.class)
@PageTitle("Club")
@PermitAll
public class ClubView extends HorizontalLayout {

    private final transient User user;
    private final transient Fixtures fixtures;
    private final transient DatabaseController dbController;


    @Autowired
    public ClubView(User user, Fixtures fixtures, DatabaseController dbController) {
        this.user = user;
        this.fixtures = fixtures;
        this.dbController = dbController;

        fixtures.prepareFixturesData();
        fixtures.updatePositions();

        setSizeFull();
        setDefaultVerticalComponentAlignment(Alignment.AUTO);
        add(clubInformation(), matchTable());

    }

    private VerticalLayout clubInformation() {
        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        H1 header = new H1(user.getClub().getName());
        Paragraph paragraph = new Paragraph("Budget: " + user.getClub().getBudget() + " PLN");
        infoLayout.add(nextMatch(), header, paragraph, previousMatches());
        return infoLayout;
    }

    private VerticalLayout matchTable() {
        VerticalLayout matchLayout = new VerticalLayout();
        matchLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        matchLayout.add(leagueTable());
        return matchLayout;
    }


    private HorizontalLayout nextMatch() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        int opponentId = fixtures.getMatchweekToFixtures().get(fixtures.getCurrentMatchweek()).get(user.getClub().getId());
        user.setNextOpponentClubId(opponentId);
        var clubOptional = fixtures.getLeagueClubs().stream().filter(club -> club.getId() == opponentId).findFirst();
        String opponentTeamName = clubOptional.map(Club::getName).orElse("Opponent Name");
        user.setNextOpponentClubName(opponentTeamName);

        Image homeTeamLogo = new Image("images/user_club_logo.png", "user_club_logo");
        homeTeamLogo.setHeight(150, Unit.PIXELS);

        Span matchweekText = new Span("Matchweek " + fixtures.getCurrentMatchweek());
        matchweekText.getStyle().set(CSS_FONT_SIZE, "1.5rem");
        matchweekText.getStyle().set("font-weight", "bold");

        Span info = new Span(user.getClub().getName() + " - " + opponentTeamName);
        info.setHeight(50, Unit.PIXELS);
        info.getStyle().set(CSS_FONT_SIZE, "1.5rem");
        info.getStyle().set("font-weight", "bold");

        Image awayTeamLogo = new Image(ClubLogo.getClubLogo(opponentTeamName), "opponent_club_logo");
        awayTeamLogo.setHeight(150, Unit.PIXELS);

        RouterLink gameplayLink = new RouterLink(GameplayView.class);
        Button playButton = new Button("Play match");
        playButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        gameplayLink.add(playButton);

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(matchweekText, info, gameplayLink);
        verticalLayout.setAlignItems(Alignment.CENTER);

        horizontalLayout.add(homeTeamLogo, verticalLayout, awayTeamLogo);
        return horizontalLayout;
    }

    private Grid<Club> leagueTable() {
        Grid<Club> grid = new Grid<>(Club.class, false);
        grid.addColumn(Club::getCurrentPosition)
                .setHeader("Position")
                .setFlexGrow(1)
                .setSortable(true);
        grid.addColumn(createLogoRenderer())
                .setFlexGrow(1);
        grid.addColumn(Club::getName)
                .setHeader("Club")
                .setFlexGrow(4);
        grid.addColumn(Club::getCurrentPoints)
                .setHeader("Points")
                .setSortable(true)
                .setFlexGrow(1);
        grid.addColumn(Club::getGoalsScored)
                .setHeader("Goals +")
                .setFlexGrow(1);
        grid.addColumn(Club::getGoalsConceded)
                .setHeader("Goals -")
                .setFlexGrow(1);

        grid.setItems(fixtures.getLeagueClubs());
        grid.setHeight(100, Unit.PERCENTAGE);
        return grid;
    }

    private Grid<Match> previousMatches() { //TODO
        Grid<Match> grid = new Grid<>(Match.class, false);
        grid.addColumn(Match::getMatchweek)
                .setHeader("Matchweek");
        grid.addColumn(Match::getHomeTeamId);
        grid.addColumn(Match::getAwayTeamId);
        grid.addColumn(Match::getHomeTeamGoals);
        grid.addColumn(Match::getAwayTeamGoals);

        grid.setItems(dbController.getClubMatches(user.getClubId()));

        return grid;
    }

    private ComponentRenderer<Image, Club> createLogoRenderer() {
        return new ComponentRenderer<>(Image::new, logoComponentUpdater);
    }

    private final SerializableBiConsumer<Image, Club> logoComponentUpdater = (image, club) -> {
        image.setSrc(ClubLogo.getClubLogo(club.getName()));
        image.setHeight(30, Unit.PIXELS);
    };

}
