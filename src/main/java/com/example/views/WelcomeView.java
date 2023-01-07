package com.example.views;

import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@Route(value = "/", layout = AppLayoutBasic.class)
@PageTitle("Welcome")
@AnonymousAllowed
public class WelcomeView extends HorizontalLayout {

    public WelcomeView() {
        setVerticalComponentAlignment(Alignment.CENTER);
        setHeight(100, Unit.PERCENTAGE);
        add(textLayout(), photoLayout());
    }

    private VerticalLayout textLayout() {
        VerticalLayout vL = new VerticalLayout();
        vL.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        vL.setWidth(500, Unit.PIXELS);
        vL.setHeight(100, Unit.PERCENTAGE);

        Image logo = new Image("images/fm_logo.png", "logo");
        logo.setHeight(200, Unit.PIXELS);
//        logo.getStyle().set("margin", "50px 0px 0px 50px");
        H1 heading = new H1("Welcome to the Football Manager");
        heading.getStyle().set("text-align", "center");
        Span description = new Span("Do you have what it takes to lead your football club to greatness? " +
                "Football Manager is the ultimate test of your managerial skills. You'll need to make tough decisions," +
                " handle the media, and keep your players and the board happy if you want to succeed." +
                " With a huge database of players and teams, you'll be able to compete in leagues and competitions all around the world." +
                " Whether you're a seasoned pro or new to the game, Football Manager offers an immersive and rewarding experience that will keep you coming back for more.");
        description.getStyle().set("text-align", "justify");

        vL.add(logo, heading, description);
        return vL;
    }

    private VerticalLayout photoLayout() {
        VerticalLayout vL = new VerticalLayout();
        vL.setHeight(100, Unit.PERCENTAGE);
        vL.setWidth(100, Unit.PERCENTAGE);

        vL.getStyle().set("background-image", "url(images/pitch_background.jpg)");
        vL.getStyle().set("background-size", "cover");
        vL.getStyle().set("background-repeat", "no-repeat");
        vL.getStyle().set("background-position", "center");
        vL.getStyle().set("opacity", "0.5");
        return vL;
    }
}
