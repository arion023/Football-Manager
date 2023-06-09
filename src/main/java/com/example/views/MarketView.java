package com.example.views;

import com.example.model.MarketOffer;
import com.example.model.entities.Club;
import com.example.model.entities.Player;
import com.example.model.User;
import com.example.model.enums.ClubLogo;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.selection.SingleSelect;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;


@Route(value = "/market", layout = AppLayoutBasic.class)
@PageTitle("Market")
@PermitAll
public class MarketView extends HorizontalLayout {
    private static final int NOTIFICATION_TIME = 1500;
    private final transient User user;
    private final Grid<MarketOffer> offersGrid = new Grid<>(MarketOffer.class);
    private final FormLayout sellForm = new FormLayout();
    ComboBox<Player> playerField;
    NumberField price;
    private final HorizontalLayout sellContent = new HorizontalLayout();
    private VerticalLayout operationSpace;
    private final VerticalLayout buttonSpace = new VerticalLayout();
    private final VerticalLayout sideBar = new VerticalLayout();
    private StatisticsDialog playerStatisticsDialog = new StatisticsDialog();
    private GridContextMenu<MarketOffer> offerContexMenu;
    private HorizontalLayout operationBar;
    private Button operationButton;
    private Tabs operationTabs;
    private Tab buyTab;
    private Tab sellTab;
    private Button budgetValue;

    @Autowired
    public MarketView(User user){
        addClassName("Market");
        setSizeFull();

        this.user = user;

        configureSideBar();
        configureOperationSpace();
        configureOffersGrid();
        configureSellForm();

        add(
                operationSpace,
                sideBar
        );
        operationSpace.setSizeFull();
        setFlexGrow(1, operationSpace);

    }


    private void configureOperationSpace() {
        configureOperationBar();
        operationSpace = new VerticalLayout(operationBar);
        operationSpace.setAlignItems(Alignment.CENTER);
        setOperation(operationTabs.getSelectedTab());

    }


    private void configureOperationBar() {

        buyTab = new Tab("Buy");
        sellTab = new Tab("Sell");
        operationTabs = new Tabs(buyTab, sellTab);
        operationTabs.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);
        operationTabs.addSelectedChangeListener(
                event -> setOperation(event.getSelectedTab())
        );
        operationBar = new HorizontalLayout(operationTabs);
        operationBar.setWidthFull();

    }


    private void resetOperationButton(){
        this.buttonSpace.remove(this.operationButton);
        this.operationButton = new Button();
        this.buttonSpace.add(this.operationButton);
        this.operationButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
    }

    private void configureSideBar() {
        this.operationButton = new Button();
        this.operationButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        this.buttonSpace.add(operationButton);
        this.buttonSpace.setJustifyContentMode(JustifyContentMode.CENTER);
        this.buttonSpace.setAlignItems(Alignment.CENTER);
        this.buttonSpace.setSizeFull();

        Component budgetInfo = getBudgetInfo(this.user);

        this.sideBar.setWidth("25em");
        this.sideBar.add(budgetInfo, buttonSpace);
    }
    private void configureOffersGrid() {
        this.offersGrid.setSizeFull();
        this.offersGrid.removeAllColumns();
        this.offersGrid.setColumns();
        this.offersGrid.addColumn(MarketOffer::getName).setHeader("Name");
        this.offersGrid.addColumn(MarketOffer::getSurname).setHeader("Surname");
        this.offersGrid.addColumn(MarketOffer::getNationality).setHeader("Nationality");
        this.offersGrid.addColumn(MarketOffer::getClubName).setHeader("Seller");
        this.offersGrid.addColumn(createLogoRenderer());
        this.offersGrid.addColumn(MarketOffer::getPosition).setHeader("Position");
        this.offersGrid.addColumn(MarketOffer::getOverall).setHeader("Overall");
        this.offersGrid.addColumn(MarketOffer::getPrice).setHeader("Price");

        this.offersGrid.setSelectionMode(Grid.SelectionMode.SINGLE);

        this.configOfferContextMenu();


        this.offersGrid.setItems(this.user.getOffers());
    }

    public ComponentRenderer<Image, MarketOffer> createLogoRenderer() {
        return new ComponentRenderer<>(Image::new, (image, marketOffer) -> {
            image.setSrc(ClubLogo.getClubLogo(marketOffer.getClubName()));
            image.setHeight(30, Unit.PIXELS);
        });
    }

    private void configOfferContextMenu() {
        offerContexMenu = this.offersGrid.addContextMenu();
        offerContexMenu.setOpenOnClick(true);

        offerContexMenu.addItem("Statistics", event -> this.showStatistics());

    }

    private void showStatistics() {
        SingleSelect<Grid<MarketOffer>, MarketOffer> playerSelect = this.offersGrid.asSingleSelect();
        if (!playerSelect.isEmpty())
        {
            playerStatisticsDialog.setPlayer(playerSelect.getValue().getPlayer());
            playerStatisticsDialog.open();

        } else
        {
            Notification selectError = Notification.show("Player not selected!");
            selectError.addThemeVariants(NotificationVariant.LUMO_ERROR);
            selectError.setPosition(Notification.Position.TOP_CENTER);
            selectError.setDuration(NOTIFICATION_TIME);
        }


    }


    private void configureSellForm() {
        playerField = new ComboBox<>("Player");
        playerField.setItems(this.user.getAllPlayers());
        playerField.setItemLabelGenerator(Player::getFullName);

        Div plnSuffix = new Div();
        plnSuffix.setText("PLN");
        price = new NumberField("Price");
        price.setSuffixComponent(plnSuffix);

        price.setLabel("Price");

        sellForm.removeAll();
        sellForm.add(playerField, price);

        sellContent.setSizeFull();
        sellContent.setAlignItems(Alignment.CENTER);
        sellContent.setJustifyContentMode(JustifyContentMode.CENTER);
        sellContent.add(sellForm);

    }



    private void setOperation(Tab selectedTab) {
        if(selectedTab.equals(buyTab)){
            resetOperationButton();
            operationButton.addClickListener(buttonClickEvent -> this.buyOperation());
            operationSpace.remove(sellContent);
            setBuying();
        } else {
            resetOperationButton();
            operationSpace.remove(offersGrid);
            setSelling();
        }

    }

    private void buyOperation() {
        SingleSelect<Grid<MarketOffer>, MarketOffer> playerSelect = this.offersGrid.asSingleSelect();
        if (!playerSelect.isEmpty()) {
            user.buyPlayer(playerSelect.getValue());

            Notification selectError = Notification.show("Successful!");
            selectError.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            selectError.setPosition(Notification.Position.TOP_CENTER);
            selectError.setDuration(NOTIFICATION_TIME);

            refreshData();
        } else {
            Notification selectError = Notification.show("Player not selected!");
            selectError.addThemeVariants(NotificationVariant.LUMO_ERROR);
            selectError.setPosition(Notification.Position.TOP_CENTER);
            selectError.setDuration(NOTIFICATION_TIME);
        }
    }

    private void refreshData() {
        this.offersGrid.setItems(this.user.getAllOffers());
        playerField.setItems(this.user.getAllPlayers());
        budgetValue.setText(String.valueOf(user.getBudget()));
    }


    private void setSelling() {
        operationButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        operationButton.addClickListener(buttonClickEvent -> this.sellOperation());
        operationButton.setText("Sell");
        operationSpace.add(sellContent);
    }

    private void sellOperation() {
        if (!(playerField.isEmpty() || price.isEmpty())) {
            user.sellPlayer(this.playerField.getValue(), price.getValue().intValue() );
            playerField.clear();
            price.clear();

            Notification selectError = Notification.show("Successful!");
            selectError.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            selectError.setPosition(Notification.Position.TOP_CENTER);
            selectError.setDuration(NOTIFICATION_TIME);

            refreshData();
        } else {
            Notification inputError = Notification.show("Empty input fields!");
            inputError.setPosition(Notification.Position.TOP_CENTER);
            inputError.setDuration(NOTIFICATION_TIME);
            inputError.addThemeVariants(NotificationVariant.LUMO_ERROR);
        }
    }


    private void setBuying() {
        operationButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        operationButton.setText("Buy");
        operationSpace.add(offersGrid);
    }


    public Component getBudgetInfo(User user) {
        Button label = new Button("Budget");
        budgetValue = new Button(String.valueOf(user.getBudget()));
        label.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_CONTRAST);
        budgetValue.addThemeVariants(ButtonVariant.LUMO_LARGE);

        VerticalLayout budgetInfo = new VerticalLayout(label, budgetValue);
        budgetInfo.setAlignItems(Alignment.CENTER);
        budgetInfo.setPadding(false);
        budgetInfo.setSpacing(false);
        return budgetInfo;
    }


}

