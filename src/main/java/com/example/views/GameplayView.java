package com.example.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.min;

@Route(value = "/gameplay", layout = AppLayoutBasic.class)
@PageTitle("Gameplay")
@PermitAll
public class GameplayView extends VerticalLayout {

    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(0);

    private int minutes = 0;

    public GameplayView() {
        setSizeFull();
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);

        add(clubsInfoLayout(), pitchLayout(), gameplayInfoLayout(), progressBarLayout());
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
        Image homeTeamLogo = new Image("images/rakow.png", "rakow");
        homeTeamLogo.setHeight(75, Unit.PIXELS);
        homeTeamLogo.setWidth(75, Unit.PIXELS);
        Span homeTeamName = new Span("Raków Częstochowa");
        homeTeamName.getStyle().set("color", "white");
        homeTeamName.getStyle().set("font-size", "1.5rem");
        homeTeamLayout.add(homeTeamLogo, homeTeamName);

        VerticalLayout matchInfoLayout = new VerticalLayout();
        matchInfoLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Span time = new Span(String.format("%02d:%02d", minutes, 0));
        time.getStyle().set("font-size", "1.5rem");
        time.getStyle().set("color", "white");
        Span result = new Span("1-2");
        result.getStyle().set("font-size", "1.5rem");
        result.getStyle().set("color", "white");

        matchInfoLayout.add(time, result);

        VerticalLayout awayTeamLayout = new VerticalLayout();
        awayTeamLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Image awayTeamLogo = new Image("images/radomiak.png", "radomiak");
        awayTeamLogo.setHeight(75, Unit.PIXELS);
        awayTeamLogo.setWidth(75, Unit.PIXELS);
        Span awayTeamName = new Span("Radomiak Radom");
        awayTeamName.getStyle().set("color", "white");
        awayTeamName.getStyle().set("font-size", "1.5rem");
        awayTeamLayout.add(awayTeamLogo, awayTeamName);

        hL.add(homeTeamLayout, matchInfoLayout, awayTeamLayout);

        return hL;
    }

    private HorizontalLayout pitchLayout() {
        HorizontalLayout hL = new HorizontalLayout();

        hL.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        hL.getStyle().set("background-image", "url(images/pitch.png)");
        hL.getStyle().set("background-size", "contain");
        hL.getStyle().set("background-repeat", "no-repeat");
        hL.getStyle().set("background-position", "center");
        hL.getStyle().set("transform", "rotate(90deg)");

        hL.setWidth(40, Unit.PERCENTAGE);
        hL.setHeight(100, Unit.PERCENTAGE);
        return hL;
    }

    private HorizontalLayout gameplayInfoLayout() {
        HorizontalLayout hL = new HorizontalLayout();

        hL.setDefaultVerticalComponentAlignment(Alignment.CENTER);
        hL.setWidth(80, Unit.PERCENTAGE);
        hL.setHeight(10, Unit.PERCENTAGE);

        hL.getStyle().set("background-color", "#4DB87B");//#286B45
        hL.getStyle().set("border-radius", "25px");

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
        executorService.schedule(executorService::shutdown, 95, TimeUnit.SECONDS);
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        executorService.shutdown();
    }

    private void updateTime(UI ui, GameplayView gameplayView) {
        gameplayView.minutes++;

        ui.access(() -> {
            gameplayView.replace(gameplayView.getComponentAt(0), gameplayView.clubsInfoLayout());
            gameplayView.replace(gameplayView.getComponentAt(3), gameplayView.progressBarLayout());
        });
    }
}
