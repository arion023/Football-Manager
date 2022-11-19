package com.example.view.list;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("fm")
public class AppLayoutBasic extends AppLayout {

    public AppLayoutBasic() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Football Manager");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        Tab club = new Tab(VaadinIcon.LIGHTBULB.create(), new Span("Club"));
        Tab league = new Tab(VaadinIcon.SHIELD.create(), new Span("League"));
        Tab market = new Tab(VaadinIcon.CART.create(), new Span("Market"));
        Tab statistic = new Tab(VaadinIcon.BAR_CHART_H.create(), new Span("Statistics"));
        Tab profile = new Tab(VaadinIcon.USER.create(), new Span("Profile"));
        Tab settings = new Tab(VaadinIcon.COG.create(), new Span("Settings"));

        RouterLink link = new RouterLink();
        Tabs tabs = new Tabs(club, league, market, statistic, profile, settings);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        addToDrawer(tabs);
        addToNavbar(toggle, title);
        setPrimarySection(Section.DRAWER);
    }
}
