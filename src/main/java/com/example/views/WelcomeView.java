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

import static com.example.model.utils.TextValues.FOOTBALL_MANAGER_DESCRIPTION;
import static com.example.model.utils.TextValues.FOOTBALL_MANAGER_WELCOME;

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
        logo.getStyle().set("margin", "50px 0px 0px 0px");

        H1 heading = new H1(FOOTBALL_MANAGER_WELCOME);
        heading.getStyle().set("text-align", "center");

        Span description = new Span(FOOTBALL_MANAGER_DESCRIPTION);
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
