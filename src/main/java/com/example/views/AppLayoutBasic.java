package com.example.views;

import com.example.controller.database.DatabaseController;
import com.example.model.entities.Player;
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

import java.util.ArrayList;

import static com.example.model.utils.CssValues.CSS_FONT_SIZE;

@Route("/")
@PageTitle("Welcome")
@AnonymousAllowed
@CssImport(value = "themes/footballmanager/styles.css", themeFor = "vaadin-app-layout")
public class AppLayoutBasic extends AppLayout {

    private final transient AuthenticationContext authContext;
    private final transient User user;
    private final transient DatabaseController dbController;
    private String clubName;
    private Dialog addNewUserDialog;
    private TextField clubNameField;
    private TextField managerNickname;


    @Autowired
    public AppLayoutBasic(AuthenticationContext authContext, User logUser, DatabaseController databaseController) {
        this.authContext = authContext;
        this.user = logUser;
        this.dbController = databaseController;

        HorizontalLayout header;
        DrawerToggle toggle = new DrawerToggle();

        H1 title = new H1("Football Manager");
        title.getStyle().set(CSS_FONT_SIZE, "var(--lumo-font-size-l)").set("margin", "0");

        if (authContext.isAuthenticated()) {
            Button logout = new Button("Logout", click -> this.authContext.logout());
            String userFullName = authContext.getAuthenticatedUser(DefaultOidcUser.class).get().getFullName(); //TODO optional check
            String usrMail = authContext.getAuthenticatedUser(DefaultOidcUser.class).get().getEmail();

            Span loggedUser;

            if (!User.setUserBasicAndClubFromDB(logUser, usrMail)) {
                user.setMail(usrMail);
                this.configAddNewUserDialog();
                this.addNewUserDialog.open();
                loggedUser = new Span("Welcome " + userFullName );
            }
            else
                loggedUser = new Span("Welcome " + user.getNickname() + " " + user.getClub().getName() + "'s manager");

            fulfillUserDataFromDB();

            loggedUser.getStyle()
                    .set(CSS_FONT_SIZE, "var(--lumo-font-size-m)");

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
        Button addButton = new Button("Create", e -> this.addNewUser(user.getMail(), managerNickname.getValue(), clubNameField.getValue()));
        addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        addNewUserDialog.getFooter().add(addButton);
    }

    private void addNewUser(String mail, String nickname, String clubName) {
        //TODO
        User.addNewUserToDB(mail, nickname, clubName, dbController);
        this.addNewUserDialog.close();
    }

    private VerticalLayout createAddNewUserLayout() {
        clubNameField = new TextField("Club name");
        managerNickname = new TextField("Manager nickname");

        VerticalLayout addNewUserLayout = new VerticalLayout(clubNameField, managerNickname);
        addNewUserLayout.setAlignItems(FlexComponent.Alignment.STRETCH);
        addNewUserLayout.setPadding(false);
        addNewUserLayout.getStyle().set("max-width", "100%").set("width", "20em");

        return addNewUserLayout;
    }

    private void fulfillUserDataFromDB() {
        //TODO move here setting club
        //user.setStadium()
        //user.setPlayers()
        //user.setOffers()
        //user.setPosition()
        user.setSubstitutes(new ArrayList<>(Player.getAllPlayersFromClubWithStats(user.getClubID(), dbController))); //347 - Lech Poznań
    }
}
