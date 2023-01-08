package com.example.views;

import com.example.model.Player;
import com.example.model.User;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.spring.security.AuthenticationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;

@Route("/")
@PageTitle("Welcome")
@AnonymousAllowed

@CssImport(value = "themes/footballmanager/styles.css", themeFor = "vaadin-app-layout")
public class AppLayoutBasic extends AppLayout {

    private final transient AuthenticationContext authContext;
    private Dialog addNewUserDialog;

    private final User user;

    @Autowired
    public AppLayoutBasic(AuthenticationContext authContext, User logUser) {
        this.authContext = authContext;
        this.user = logUser;

        HorizontalLayout header;
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Football Manager");
        title.getStyle().set("font-size", "var(--lumo-font-size-l)").set("margin", "0");

        if (authContext.isAuthenticated()) {
            Button logout = new Button("Logout", click -> this.authContext.logout());
            String userFullName = authContext.getAuthenticatedUser(DefaultOidcUser.class).get().getFullName(); //TODO optional check
            String usrMail = authContext.getAuthenticatedUser(DefaultOidcUser.class).get().getEmail();

            if (!User.setUserInfoFromDB(logUser, usrMail)) {
                this.configAddNewUserDialog();
                this.addNewUserDialog.open();
            }
            getUserDataFromDB();

            Span loggedUser = new Span("Welcome " + userFullName);
            loggedUser.getStyle()
                    .set("font-size", "var(--lumo-font-size-m)");

            header = new HorizontalLayout(toggle, title, loggedUser, logout);
        } else {
            header = new HorizontalLayout(toggle, title);
        }
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        Tab welcome = new Tab(VaadinIcon.INFO_CIRCLE_O.create(), new RouterLink("Welcome", WelcomeView.class));
        Tab club = new Tab(VaadinIcon.LIGHTBULB.create(), new RouterLink("Club", ClubView.class));
        Tab squad = new Tab(VaadinIcon.SHIELD.create(), new RouterLink("Squad", SquadView.class));
        Tab market = new Tab(VaadinIcon.CART.create(), new RouterLink("Market", MarketView.class));
        Tab statistic = new Tab(VaadinIcon.BAR_CHART_H.create(), new RouterLink("Statistics", StatisticsView.class));
//        Tab profile = new Tab(VaadinIcon.USER.create(), new RouterLink("Profile", CoachView.class));
        Tab settings = new Tab(VaadinIcon.COG.create(), new RouterLink("Settings", SettingsView.class));

        Tabs tabs = new Tabs(welcome, club, squad, market, statistic, settings);
        tabs.setOrientation(Tabs.Orientation.VERTICAL);

        addToDrawer(tabs);
        addToNavbar(header);
        setPrimarySection(Section.DRAWER);
    }

    private void configAddNewUserDialog() {
        this.addNewUserDialog = new Dialog();
        this.addNewUserDialog.setHeaderTitle("New User");

        VerticalLayout dialogLayout = createAddNewUserLayout();
        this.addNewUserDialog.add(dialogLayout);
        Button addButton = new Button("Create", e -> this.addNewUser());
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addNewUserDialog.getFooter().add(addButton);
    }

    private void addNewUser() {
        //TODO
        this.addNewUserDialog.close();
    }

    private VerticalLayout createAddNewUserLayout() {
        TextField clubName = new TextField("Club name");
        TextField managerNickname = new TextField("Manager nickname");

        VerticalLayout addNewUserLayout = new VerticalLayout(clubName, managerNickname);
        addNewUserLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        addNewUserLayout.setPadding(false);
        addNewUserLayout.getStyle().set("max-width", "100%").set("width", "20em");

        return addNewUserLayout;
    }

    private void getUserDataFromDB(){
        user.setSubstitutes(Player.getAllPlayersFromClub(347)); //347 - Lech Poznań
    }
}
