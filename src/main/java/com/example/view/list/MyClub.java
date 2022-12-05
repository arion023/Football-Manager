package com.example.view.list;

import com.example.model.Address;
import com.example.model.Club;
import com.example.model.Country;
import com.example.model.Stadium;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;

@Route(value = "club", layout = AppLayoutBasic.class)
@PageTitle("Your Club")

public class MyClub extends HorizontalLayout {
    Stadium stadium = new Stadium(1,"Stadion Wojska Polskiego", new Address(1, "Łazienkowska", 3, "Warszawa", new Country(1, "Polska", "POL")), 30000, LocalDate.of(1930, 8, 9));
    Club club = new Club(1, "Legia Warszawa", null, null, 100000000, null, null, stadium, null, null);

    public MyClub() {
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
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
        matchLayout.setAlignItems(Alignment.CENTER);
        matchLayout.add(new H2("TODO match"));
        matchLayout.add(new H2("TODO table"));
        return matchLayout;
    }

    private Details detailsLayout() {
        Span stadium = new Span("Stadium: " + club.getStadium().getName() + ", " + club.getStadium().getAddress().getAddressString());
        Span builtIn = new Span( "\nBuilt in: " + club.getStadium().getBuildDate()
        + ", Capacity: " + club.getStadium().getCapacity());
        // TODO trophies list
        VerticalLayout content = new VerticalLayout();
        content.add(stadium);
        content.add(builtIn);
        Details details = new Details("Details:", content);
        details.setOpened(false);
        return details;
    }


}
