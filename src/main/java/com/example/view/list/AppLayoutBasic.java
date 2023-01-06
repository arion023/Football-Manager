package com.example.view.list;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

@Route("/")
@PageTitle("Welcome")
@AnonymousAllowed
public class AppLayoutBasic extends AppLayout {

    private final transient AuthenticationContext authContext;

    public AppLayoutBasic(AuthenticationContext authContext) {
        this.authContext = authContext;

        HorizontalLayout header;
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Football Manager");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        if (authContext.isAuthenticated()) {
            Button logout = new Button("Logout", click -> this.authContext.logout());
            String userFullName = authContext.getAuthenticatedUser(DefaultOidcUser.class).get().getFullName(); //TODO optional check

            Span loggedUser = new Span("Welcome " + userFullName);
            loggedUser.getStyle()
                    .set("font-size", "var(--lumo-font-size-m)");

            header = new HorizontalLayout(toggle, title, loggedUser, logout);
        } else {
            header = new HorizontalLayout(toggle, title);
        }
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        Tab club = new Tab(VaadinIcon.LIGHTBULB.create(), new RouterLink("Club", ClubView.class));
        Tab squad = new Tab(VaadinIcon.SHIELD.create(), new RouterLink("Squad", SquadView.class));
        Tab market = new Tab(VaadinIcon.CART.create(), new RouterLink("Market", MarketView.class));
        Tab statistic = new Tab(VaadinIcon.BAR_CHART_H.create(), new RouterLink("Statistics", StatisticsView.class));
        Tab profile = new Tab(VaadinIcon.USER.create(), new RouterLink("Profile", CoachView.class));
        Tab settings = new Tab(VaadinIcon.COG.create(), new RouterLink("Settings", SettingsView.class));

        Tabs tabs = new Tabs(club, squad, market, statistic, profile, settings);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        addToDrawer(tabs);
        addToNavbar(header);
        setPrimarySection(Section.DRAWER);
    }
}
