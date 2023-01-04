package com.example.view.list;

import com.example.model.MarketOffer;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value = "market", layout = AppLayoutBasic.class)
@PageTitle("Transfer market")

public class Market extends HorizontalLayout {
    Grid<MarketOffer> offersGrid = new Grid<>(MarketOffer.class);
    VerticalLayout operationSpace;

    VerticalLayout buttonSpace;
    Button operationButton;
    Tabs operationBar;
    Tab buyTab;
    Tab sellTab;
    public Market(){
        addClassName("Market");
        setSizeFull();

        configureButtonSpace();
        configureOperationSpace();
        configureOffersGrid();

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
        setOperation(operationBar.getSelectedTab());

    }


    private void configureOperationBar() {
        buyTab = new Tab("Buy");
        sellTab = new Tab("Sell");
        operationBar = new Tabs(buyTab, sellTab);
        operationBar.addThemeVariants(TabsVariant.LUMO_EQUAL_WIDTH_TABS);
        operationBar.setWidth("25em");
        operationBar.addSelectedChangeListener(
                event -> setOperation(event.getSelectedTab())
        );

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

    private void configureButtonSpace() {
        operationButton = new Button();
        operationButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSpace = new VerticalLayout();
        buttonSpace.add(operationButton);
        buttonSpace.setJustifyContentMode(JustifyContentMode.CENTER);
        buttonSpace.setAlignItems(Alignment.CENTER);
        buttonSpace.setWidth("25em");
    }


    private void setOperation(Tab selectedTab) {

        if(selectedTab.equals(buyTab)){
            //TODO operationSpace.remove();
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
        //operationContent.add(sellingForm);;
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
        label.getElement().getThemeList().add("badge");
        budgetValue.getElement().getThemeList().add("badge");
        VerticalLayout budgetInfo = new VerticalLayout(label, budgetValue);
        return budgetInfo;
    }

}
