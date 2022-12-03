package com.example.view.list;

import com.example.model.Club;
import com.example.model.Coach;
import com.example.model.Country;
import com.example.model.Player;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LocalDateRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Route(value = "coach-profile", layout = AppLayoutBasic.class)
@PageTitle("Profile")

public class MyCoach extends VerticalLayout {
    Club club = new Club(1, "Legia Warszawa", null, null, 0, null, null, null, null, null);
    Coach coach  =  new Coach(1, "Czeslaw", "Michniewicz", LocalDate.of(1980, 1,1),
            new Country(1, "Poland", "POL"), club, getSampleClubs()); //TODO link to player

    public MyCoach() {
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        add(new H2(coach.getName() + " " + coach.getSurname()));
        add(new Paragraph("Club: " + club.getName()));
        add(detailsLayout());
        add(new H2("Former clubs:"));
        add(clubListLayout());
    }

    private Details detailsLayout() {
        Span birth_date = new Span("Date of birth: " + coach.getBirthDate());
        Span country = new Span("Country: " + coach.getCountry().getName());
        VerticalLayout content = new VerticalLayout(country, birth_date);
        content.setPadding(false);
        content.setSpacing(false);
        Details details = new Details("Details", content);
        details.setOpened(false);
        return details;
    }

    private HorizontalLayout clubListLayout() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        MultiSelectListBox<Club> multiSelectListBox = new MultiSelectListBox<>();
        multiSelectListBox.setItems(coach.getClubsHistory());
        multiSelectListBox.setRenderer(new ComponentRenderer<>(club -> {
            HorizontalLayout row = new HorizontalLayout();
            row.setAlignItems(Alignment.CENTER);

            Icon icon = new Icon(VaadinIcon.BRIEFCASE);

            Span name = new Span(club.getName());

            row.add(icon, name);
            row.getStyle().set("line-height", "var(--lumo-line-height-m)");
            return row;
        }));
        horizontalLayout.add(multiSelectListBox);
        return horizontalLayout;
    }
    private List<Club> getSampleClubs() { // TODO
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club(1, "Arka Gdynia", null, null, 0, null, null, null, null, null));
        clubs.add(new Club(2, "Radomiak Radom", null, null, 0, null, null, null, null, null));
        clubs.add(new Club(3, "Wisla Plock", null, null, 0, null, null, null, null, null));

        return clubs;
    }
}
