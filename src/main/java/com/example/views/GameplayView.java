package com.example.views;

import com.example.model.Club;
import com.example.model.GameplayEvents;
import com.example.model.Player;
import com.example.model.User;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.min;

@Route(value = "/gameplay", layout = AppLayoutBasic.class)
@PageTitle("Gameplay")
@PermitAll
public class GameplayView extends VerticalLayout {

    private static final int MATCH_DURATION = 30;//In real seconds
    private final transient ScheduledExecutorService executorService = Executors.newScheduledThreadPool(0);
    private final Dialog dialog = new Dialog();

    private final User user;

    private int minutes = 0;
    private int homeTeamGoals = 0;
    private int awayTeamGoals = 0;


    @Autowired
    public GameplayView(User user) {
        this.user = user;

        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        dialog.setHeaderTitle("Match finished");
        dialog.add(dialogLayout());
        dialog.setCloseOnOutsideClick(false);
        dialog.setCloseOnEsc(false);

        RouterLink clubLink = new RouterLink(ClubView.class);
        Button button = new Button("Go back to club");
        button.addClickListener(event -> saveMatch());
        clubLink.add(button);
        dialog.getFooter().add(clubLink);

        add(clubsInfoLayout(), pitchLayout(), gameplayInfoLayout("The match will begin soon"), progressBarLayout(), dialog);
    }

    private VerticalLayout dialogLayout() {
        VerticalLayout dialogLayout = new VerticalLayout();
        dialogLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        dialogLayout.getStyle().set("width", "18rem").set("max-width", "100%");

        Image homeTeamLogo = new Image("images/user_club_logo.png", "user_club_logo");
        homeTeamLogo.setHeight(50, Unit.PIXELS);
        homeTeamLogo.setWidth(50, Unit.PIXELS);

        Image awayTeamLogo = new Image("images/rakow.png", "raków");
        awayTeamLogo.setHeight(50, Unit.PIXELS);
        awayTeamLogo.setWidth(50, Unit.PIXELS);

        HorizontalLayout clubLogos = new HorizontalLayout(homeTeamLogo, awayTeamLogo);

        Span teams = new Span(user.getClub().getName() + " - " + user.getNextOpponentClubName());
        teams.getStyle().set("font-size", "1.2rem");
        Span result = new Span(homeTeamGoals + " - " + awayTeamGoals);
        result.getStyle().set("font-size", "1.5rem");
        dialogLayout.add(clubLogos, teams, result);

        return dialogLayout;
    }

    private void saveMatch() {

    }

    private HorizontalLayout clubsInfoLayout() {
        HorizontalLayout hL = new HorizontalLayout();

        hL.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        hL.setWidth(60, Unit.PERCENTAGE);
        hL.setHeight(15, Unit.PERCENTAGE);

        hL.getStyle().set("background-color", "#4DB87B");//#286B45
        hL.getStyle().set("border-radius", "25px");

        VerticalLayout homeTeamLayout = new VerticalLayout();
        homeTeamLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Image homeTeamLogo = new Image("images/user_club_logo.png", "user_club_logo");
        homeTeamLogo.setHeight(75, Unit.PIXELS);
        homeTeamLogo.setWidth(75, Unit.PIXELS);

        Span homeTeamName = new Span(user.getClub().getName());
        homeTeamName.getStyle().set("color", "white");
        homeTeamName.getStyle().set("font-size", "1.5rem");
        homeTeamLayout.add(homeTeamLogo, homeTeamName);

        VerticalLayout matchInfoLayout = new VerticalLayout();
        matchInfoLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Span time = new Span(String.format("%02d:%02d", minutes, 0));
        time.getStyle().set("font-size", "2rem");
        time.getStyle().set("color", "white");
        Span result = new Span(homeTeamGoals + " - " + awayTeamGoals);
        result.getStyle().set("font-size", "2rem");
        result.getStyle().set("color", "white");

        matchInfoLayout.add(time, result);

        VerticalLayout awayTeamLayout = new VerticalLayout();
        awayTeamLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Image awayTeamLogo = new Image("images/radomiak.png", "radomiak");
        awayTeamLogo.setHeight(75, Unit.PIXELS);
        awayTeamLogo.setWidth(75, Unit.PIXELS);
        Span awayTeamName = new Span(user.getNextOpponentClubName());
        awayTeamName.getStyle().set("color", "white");
        awayTeamName.getStyle().set("font-size", "1.5rem");
        awayTeamLayout.add(awayTeamLogo, awayTeamName);

        hL.add(homeTeamLayout, matchInfoLayout, awayTeamLayout);

        return hL;
    }

    private HorizontalLayout pitchLayout() {
        HorizontalLayout hL = new HorizontalLayout();

        hL.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        hL.setJustifyContentMode(JustifyContentMode.BETWEEN);
        hL.getStyle().set("background-image", "url(images/pitch_horizontal.png)");
        hL.getStyle().set("background-size", "contain");
        hL.getStyle().set("background-repeat", "no-repeat");
        hL.getStyle().set("background-position", "center");

        hL.setWidth(100, Unit.PERCENTAGE);
        hL.setHeight(50, Unit.PERCENTAGE);

        Grid<Player> homeTeamGrid = createPlayersGrid();
        Grid<Player> awayTeamGrid = createPlayersGrid();

        homeTeamGrid.setItems(user.getFirstSquad());
        awayTeamGrid.setItems(Player.getAllPlayersFromClub(user.getNextOpponentClubId()).subList(0,11));//TODO wybrać dobre pozycje

        homeTeamGrid.setMaxWidth(500, Unit.PIXELS);
        awayTeamGrid.setMaxWidth(500, Unit.PIXELS);

        hL.add(homeTeamGrid, awayTeamGrid);

        return hL;
    }

    private Grid<Player> createPlayersGrid() {
        Grid<Player> grid = new Grid<>(Player.class, false);
        grid.addColumn(new ComponentRenderer<>(e -> new Icon(VaadinIcon.USER)))
                .setAutoWidth(true)
                .setFlexGrow(1);
        grid.addColumn(Player::getName)
                .setHeader("Imie")
                .setAutoWidth(true)
                .setFlexGrow(3);
        grid.addColumn(Player::getSurname)
                .setHeader("Nazwisko")
                .setAutoWidth(true)
                .setFlexGrow(3);
        grid.addColumn(Player::getPosition)
                .setHeader("Pozycja")
                .setAutoWidth(true)
                .setFlexGrow(3)
                .setSortable(true);
        return grid;
    }

    private HorizontalLayout gameplayInfoLayout(String message) {
        HorizontalLayout hL = new HorizontalLayout();

        hL.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        hL.setWidth(80, Unit.PERCENTAGE);
        hL.setHeight(10, Unit.PERCENTAGE);

        hL.getStyle().set("background-color", "#4DB87B");//#286B45
        hL.getStyle().set("border-radius", "25px");

        VerticalLayout vL = new VerticalLayout();
        vL.setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        Span spanMessage = new Span(message);
        spanMessage.getStyle().set("font-size", "1.75rem");
        spanMessage.getStyle().set("color", "white");
        spanMessage.getStyle().set("text-align", "center");

        vL.add(spanMessage);

        hL.add(vL);

        return hL;
    }

    private HorizontalLayout progressBarLayout() {
        HorizontalLayout hL = new HorizontalLayout();
        hL.setDefaultVerticalComponentAlignment(Alignment.STRETCH);
        hL.setWidth(80, Unit.PERCENTAGE);

        ProgressBar minutesBar = new ProgressBar();
        minutesBar.setHeight(25, Unit.PIXELS);

        minutesBar.setMin(0);
        minutesBar.setMax(90);
        minutesBar.setValue(min(minutes, 90));

        hL.add(minutesBar);

        return hL;
    }

    @Override
    protected void onAttach(AttachEvent attachEvent) {
        executorService.scheduleAtFixedRate(() -> updateTime(attachEvent.getUI(), this), 1, 1, TimeUnit.SECONDS);
        executorService.scheduleAtFixedRate(() -> updateInfo(attachEvent.getUI(), this), 2, 3, TimeUnit.SECONDS);
        executorService.schedule(() -> endGameplay(attachEvent.getUI(), this), MATCH_DURATION, TimeUnit.SECONDS);
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        executorService.shutdown();
    }

    private void updateTime(UI ui, GameplayView gameplayView) {
        gameplayView.minutes = gameplayView.minutes + 90 / MATCH_DURATION;

        ui.access(() -> {
            gameplayView.replace(gameplayView.getComponentAt(0), gameplayView.clubsInfoLayout());
            gameplayView.replace(gameplayView.getComponentAt(3), gameplayView.progressBarLayout());
        });
    }

    private void updateInfo(UI ui, GameplayView gameplayView) {
        GameplayEvents event = GameplayEvents.getRandomEvent();
        String message;
        String teamName = GameplayEvents.getTeam() == 0 ? "Home Team" : "Away Team";
        switch (event) {
            case GOAL:
                message = String.format(event.getDescription(), teamName);
                if ("Home Team".equals(teamName)) {
                    homeTeamGoals++;
                } else {
                    awayTeamGoals++;
                }
                break;
            default:
                message = event.getDescription();
        }
        ui.access(() -> gameplayView.replace(gameplayView.getComponentAt(2), gameplayView.gameplayInfoLayout(message)));
    }

    private void endGameplay(UI ui, GameplayView gameplayView) {
        executorService.shutdown();
        ui.access(gameplayView.dialog::open);
    }
}
