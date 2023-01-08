package com.example.views;

import com.example.model.entities.Club;
import com.example.model.enums.ClubLogo;
import com.example.model.Fixtures;
import com.example.model.User;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

import static com.example.model.utils.CssValues.CSS_FONT_SIZE;

@Route(value = "/club", layout = AppLayoutBasic.class)
@PageTitle("Club")
@PermitAll
public class ClubView extends HorizontalLayout {

    private final transient User user;
    private final transient Fixtures fixtures;


    @Autowired
    public ClubView(User user, Fixtures fixtures) {
        this.user = user;
        this.fixtures = fixtures;

        setSizeFull();
        setDefaultVerticalComponentAlignment(Alignment.AUTO);
        add(clubInformation(), matchTable());

    }

    private VerticalLayout clubInformation() {
        VerticalLayout infoLayout = new VerticalLayout();
        infoLayout.setAlignItems(Alignment.CENTER);
        H2 header = new H2(user.getClub().getName());
        Paragraph paragraph = new Paragraph("Budget: " + user.getClub().getBudget() + " zl");
        infoLayout.add(nextMatch(), header, paragraph, detailsLayout());
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
        String opponentTeamName = fixtures.getLeagueClubs().stream().filter(club -> club.getId() == opponentId).findFirst().get().getName();
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
        grid.addColumn(Club::getName).setHeader("Club:");
        grid.addColumn(c -> c.getPoints()).setHeader("Points:").setSortable(true); //TODO getPoints shouldnt be static

        grid.setItems(fixtures.getLeagueClubs());
        grid.setHeight(100, Unit.PERCENTAGE);
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
