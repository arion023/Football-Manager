package com.example.view.list;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.map.configuration.View;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class AppLayoutBasic extends AppLayout {

    public AppLayoutBasic() {
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Football Manager");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        Tab club = new Tab(VaadinIcon.LIGHTBULB.create(), new RouterLink("Club", MyClub.class));
        Tab squad = new Tab(VaadinIcon.SHIELD.create(), new RouterLink("Squad", SquadView.class));
        Tab market = new Tab(VaadinIcon.CART.create(), new RouterLink("Market", Market.class));
        Tab statistic = new Tab(VaadinIcon.BAR_CHART_H.create(), new RouterLink("Statistics", Statistics.class));
        Tab profile = new Tab(VaadinIcon.USER.create(), new RouterLink("Profile", MyCoach.class));
        Tab settings = new Tab(VaadinIcon.COG.create(), new RouterLink("Settings", Settings.class));

        RouterLink link = new RouterLink();
        Tabs tabs = new Tabs(club, squad, market, statistic, profile, settings);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        addToDrawer(tabs);
        addToNavbar(toggle, title);
        setPrimarySection(Section.DRAWER);
    }
}
