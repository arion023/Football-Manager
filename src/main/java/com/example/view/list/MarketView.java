package com.example.view.list;

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


@Route(value = "/market", layout = AppLayoutBasic.class)
@PageTitle("Market")
@PreserveOnRefresh
@PermitAll
public class MarketView extends HorizontalLayout {
    User loggedUser;
    Grid<MarketOffer> offersGrid = new Grid<>(MarketOffer.class);
    FormLayout sellForm = new FormLayout();
    HorizontalLayout sellContent = new HorizontalLayout();
    VerticalLayout operationSpace;

    VerticalLayout buttonSpace = new VerticalLayout();
    VerticalLayout sideBar = new VerticalLayout();
    HorizontalLayout operationBar;
    Button operationButton;
    Tabs operationTabs;
    Tab buyTab;
    Tab sellTab;
    @Autowired
    public MarketView(User loggedUser){
        addClassName("Market");
        setSizeFull();

        this.loggedUser = loggedUser;
        //this.loggedUser.setUserInfo("masikow200@gmail.com");
        //User.getUserInfoFromDB("");
        Player.getAllPlayersFromDB();

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

        Component budgetInfo = getBudgetInfo(this.loggedUser);

        sideBar.setWidth("25em");
        sideBar.add(budgetInfo, buttonSpace);
    }
    private void configureOffersGrid() {
        offersGrid.setSizeFull();
        offersGrid.setColumns();
        offersGrid.addColumn(MarketOffer::getName).setHeader("Name");
        offersGrid.addColumn(MarketOffer::getSurname).setHeader("Surname");
        offersGrid.addColumn(MarketOffer::getNationality).setHeader("Nationality");
        offersGrid.addColumn(MarketOffer::getSeller).setHeader("Seller");
        offersGrid.addColumn(MarketOffer::getPosition).setHeader("Position");
        offersGrid.addColumn(MarketOffer::getOverall).setHeader("Overall");
        offersGrid.addColumn("price");
    }


    private void configureSellForm() {
        ComboBox<Player> playerForm = new ComboBox<>("Player");
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


    static public Component getBudgetInfo(User loggedUser) {
        //TODO HOW TO ADD BUDGET?
        Button label = new Button("Budget");
        Button budgetValue = new Button(String.valueOf(loggedUser.getBudget()));
        label.addThemeVariants(ButtonVariant.LUMO_LARGE, ButtonVariant.LUMO_TERTIARY, ButtonVariant.LUMO_CONTRAST);
        budgetValue.addThemeVariants(ButtonVariant.LUMO_LARGE);

        VerticalLayout budgetInfo = new VerticalLayout(label, budgetValue);
        budgetInfo.setAlignItems(Alignment.CENTER);
        budgetInfo.setPadding(false);
        budgetInfo.setSpacing(false);
        return budgetInfo;
    }


}

