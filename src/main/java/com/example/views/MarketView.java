package com.example.views;

import com.example.controller.database.DatabaseController;
import com.example.model.MarketOffer;
import com.example.model.entities.Player;
import com.example.model.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.data.selection.SingleSelect;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;


@Route(value = "/market", layout = AppLayoutBasic.class)
@PageTitle("Market")
@PreserveOnRefresh
@PermitAll
public class MarketView extends HorizontalLayout {
    private final transient User user;
    private final transient DatabaseController dbController;
    private Grid<MarketOffer> offersGrid = new Grid<>(MarketOffer.class);
    private FormLayout sellForm = new FormLayout();
    ComboBox<Player> playerField;
    NumberField price;
    private HorizontalLayout sellContent = new HorizontalLayout();
    private VerticalLayout operationSpace;
    private VerticalLayout buttonSpace = new VerticalLayout();
    private VerticalLayout sideBar = new VerticalLayout();
    private HorizontalLayout operationBar;
    private Button operationButton;
    private Tabs operationTabs;
    private Tab buyTab;
    private Tab sellTab;
    private Button budgetValue;

    @Autowired
    public MarketView(User user, DatabaseController dbController){
        addClassName("Market");
        setSizeFull();

        this.dbController = dbController;
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
        this.offersGrid.addColumn(MarketOffer::getSellerId).setHeader("Seller");
        this.offersGrid.addColumn(MarketOffer::getPosition).setHeader("Position");
        this.offersGrid.addColumn(MarketOffer::getOverall).setHeader("Overall");
        this.offersGrid.addColumn(MarketOffer::getPrice).setHeader("Price");

        this.offersGrid.setSelectionMode(Grid.SelectionMode.SINGLE);

        this.offersGrid.setItems(this.user.getAllOffers());

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
            refreshData();
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
        //operationContent.setFlexGrow(2, sellingForm);
    }

    private void sellOperation() {
        //setOperation(this.sellTab);
        if (!(playerField.isEmpty() || price.isEmpty())) {
            user.sellPlayer(this.playerField.getValue(), price.getValue().intValue() );
            playerField.clear();
            price.clear();
            refreshData();
        }
    }


    private void setBuying() {
        operationButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
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

