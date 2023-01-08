package com.example.views;

import com.example.controller.database.DatabaseController;
import com.example.model.MarketOffer;
import com.example.model.Player;
import com.example.model.User;
import com.vaadin.flow.component.Component;
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
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.util.List;


@Route(value = "/market", layout = AppLayoutBasic.class)
@PageTitle("Market")
@PreserveOnRefresh
@PermitAll
public class MarketView extends HorizontalLayout {
    private final transient User user;
    private final transient DatabaseController dbController;
    private Grid<MarketOffer> offersGrid = new Grid<>(MarketOffer.class);
    private FormLayout sellForm = new FormLayout();
    private HorizontalLayout sellContent = new HorizontalLayout();
    private VerticalLayout operationSpace;
    private VerticalLayout buttonSpace = new VerticalLayout();
    private VerticalLayout sideBar = new VerticalLayout();
    private HorizontalLayout operationBar;
    private Button operationButton;
    private Tabs operationTabs;
    private Tab buyTab;
    private Tab sellTab;

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

    private void configureSideBar() {
        operationButton = new Button();
        operationButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        buttonSpace.add(operationButton);
        buttonSpace.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonSpace.setAlignItems(Alignment.CENTER);
        buttonSpace.setSizeFull();

        Component budgetInfo = getBudgetInfo(this.user);

        sideBar.setWidth("25em");
        sideBar.add(budgetInfo, buttonSpace);
    }
    private void configureOffersGrid() {
        offersGrid.setSizeFull();
        offersGrid.setColumns();
        offersGrid.addColumn(MarketOffer::getName).setHeader("Name");
        offersGrid.addColumn(MarketOffer::getSurname).setHeader("Surname");
        offersGrid.addColumn(MarketOffer::getNationality).setHeader("Nationality");
        offersGrid.addColumn(MarketOffer::getSellerId).setHeader("Seller");
        offersGrid.addColumn(MarketOffer::getPosition).setHeader("Position");
        offersGrid.addColumn(MarketOffer::getOverall).setHeader("Overall");
        offersGrid.addColumn(MarketOffer::getPrice).setHeader("Price");

        List<MarketOffer> offers = MarketOffer.getOffers(this.dbController);

        offersGrid.setItems(offers);

    }


    private void configureSellForm() {
        ComboBox<Player> playerForm = new ComboBox<>("Player");
        playerForm.setItems(Player.getPlayersByClub(this.user.getClubID(), this.dbController));
        playerForm.setItemLabelGenerator(Player::getFullName);

        Div plnSuffix = new Div();
        plnSuffix.setText("PLN");
        NumberField price = new NumberField("Price");
        price.setSuffixComponent(plnSuffix);

        price.setLabel("Price");

        sellForm.add(playerForm, price);

        sellContent.setSizeFull();
        sellContent.setAlignItems(Alignment.CENTER);
        sellContent.setJustifyContentMode(JustifyContentMode.CENTER);
        sellContent.add(sellForm);

    }



    private void setOperation(Tab selectedTab) {
        if(selectedTab.equals(buyTab)){
            operationSpace.remove(sellContent);
            operationButton.removeThemeVariants(ButtonVariant.LUMO_SUCCESS);
            setBuying();
        } else {
            operationSpace.remove(offersGrid);
            operationButton.removeThemeVariants(ButtonVariant.LUMO_ERROR);
            setSelling();
        }

    }


    private void setSelling() {
        operationButton.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        operationButton.setText("Sell");
        operationSpace.add(sellContent);
        //operationContent.setFlexGrow(2, sellingForm);
    }


    private void setBuying() {
        operationButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        operationButton.setText("Buy");
        operationSpace.add(offersGrid);
    }


    public static Component getBudgetInfo(User user) {
        Button label = new Button("Budget");
        Button budgetValue = new Button(String.valueOf(user.getBudget()));
        label.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_CONTRAST);
        budgetValue.addThemeVariants(ButtonVariant.LUMO_LARGE);

        VerticalLayout budgetInfo = new VerticalLayout(label, budgetValue);
        budgetInfo.setAlignItems(Alignment.CENTER);
        budgetInfo.setPadding(false);
        budgetInfo.setSpacing(false);
        return budgetInfo;
    }


}

