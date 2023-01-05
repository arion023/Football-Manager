package com.example.view.list;

import com.example.model.MarketOffer;
import com.example.model.Player;
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
import com.vaadin.flow.router.Route;



@Route(value = "market", layout = AppLayoutBasic.class)
@PageTitle("Transfer market")

public class Market extends HorizontalLayout {
    Grid<MarketOffer> offersGrid = new Grid<>(MarketOffer.class);
    FormLayout sellForm = new FormLayout();
    VerticalLayout operationSpace;

    VerticalLayout buttonSpace;
    HorizontalLayout operationBar;
    Button operationButton;
    Tabs operationTabs;
    Tab buyTab;
    Tab sellTab;
    public Market(){
        addClassName("Market");
        setSizeFull();

        configureButtonSpace();
        configureOperationSpace();
        configureOffersGrid();
        configureSellForm();

        add(
                operationSpace,
                buttonSpace
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
        operationTabs.setWidth("40em");
        operationTabs.addSelectedChangeListener(
                event -> setOperation(event.getSelectedTab())
        );
        Component budgetInfo = getBudgetInfo();
        operationBar = new HorizontalLayout(operationTabs, budgetInfo);
        operationBar.setFlexGrow(2, operationTabs);
        operationBar.setFlexGrow(1, budgetInfo);

    }

    private void configureButtonSpace() {
        operationButton = new Button();
        operationButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSpace = new VerticalLayout();
        Component budgetInfo = getBudgetInfo();
        buttonSpace.add(budgetInfo, operationButton);
        buttonSpace.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonSpace.setAlignItems(Alignment.CENTER);
        buttonSpace.setWidth("25em");
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


    }



    private void setOperation(Tab selectedTab) {
        if(selectedTab.equals(buyTab)){
            operationSpace.remove(sellForm);
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
        operationSpace.add(sellForm);
        //operationContent.setFlexGrow(2, sellingForm);
    }


    private void setBuying() {
        operationButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        operationButton.setText("Buy");
        operationSpace.add(offersGrid);
    }


    private Component getBudgetInfo() {
        Span label = new Span("Budget");
        //TODO HOW TO ADD BUDGET?
        Span budgetValue = new Span(String.valueOf(1000));
        budgetValue.getElement().getThemeList().add("badge primary");
        VerticalLayout budgetInfo = new VerticalLayout(label, budgetValue);
        budgetInfo.setAlignItems(Alignment.CENTER);
        budgetInfo.setWidth("20em");
        return budgetInfo;
    }



}

