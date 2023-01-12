package com.example.views;

import com.example.model.MarketOffer;
import com.example.model.entities.Player;
import com.example.model.entities.Statistics;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import javax.naming.Name;

public class StatisticsDialog extends Dialog {

    Label playerName = new Label();
    HorizontalLayout statisticsContent;
    VerticalLayout firstColumn = new VerticalLayout();
    VerticalLayout secondColumn = new VerticalLayout();
    VerticalLayout overallLayout = new VerticalLayout();
    Span overall = new Span();
    Label overallLabel = new Label("Overall: ");

    StatisticsDialog (){
        this.setHeaderTitle("Statistics");
        this.configLayout();
    }

    private void configLayout() {
        VerticalLayout dialogLayout = new VerticalLayout();
        this.statisticsContent = new HorizontalLayout(firstColumn, secondColumn);

        this.playerName.getElement().getStyle().set("font-weight", "bold");
        this.playerName.getElement().getStyle().set("font-size", "20px");

        this.overall.getElement().getThemeList().add("badge contrast");
        this.overall.getElement().getStyle().set("font-size", "28px");

        this.overallLabel.getElement().getStyle().set("font-size", "18px");
        this.overallLabel.getElement().getStyle().set("font-weight", "bold");

        this.overallLayout.add(overallLabel, overall);
        this.overallLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        this.overallLayout.setFlexGrow(1);

        Button closeButton = new Button("Close", buttonClickEvent -> { this.close(); });

        dialogLayout.add(this.playerName, overallLayout, statisticsContent, closeButton);
        dialogLayout.setPadding(false);
        dialogLayout.setAlignItems(FlexComponent.Alignment.CENTER);


        this.add(dialogLayout);
    }

    public void setPlayer(Player player) {
        Statistics ps = player.getStatistics();

        this.playerName.setText(player.getFullName());

        this.firstColumn.removeAll();
        this.secondColumn.removeAll();

        this.overall.setText(Integer.toString(ps.getOverall()));

        VerticalLayout pace = new VerticalLayout(StatisticsDialog.statisticRow("Pace: ", ps.getPace()));
        VerticalLayout shooting = new VerticalLayout(StatisticsDialog.statisticRow("Shooting: ", ps.getShooting()));
        VerticalLayout passing = new VerticalLayout(StatisticsDialog.statisticRow("Passing: ", ps.getPassing()));
        VerticalLayout dribbling = new VerticalLayout(StatisticsDialog.statisticRow("Dribbling: ", ps.getDribbling()));
        VerticalLayout defence = new VerticalLayout( StatisticsDialog.statisticRow("Defence: ", ps.getDefence()) );
        VerticalLayout physical = new VerticalLayout( StatisticsDialog.statisticRow("Physical: ", ps.getPhysically()) );

        this.firstColumn.add(pace, shooting, passing);
        this.secondColumn.add(dribbling, defence, physical);

    }



    static HorizontalLayout statisticRow(String name, int value)
    {
        HorizontalLayout row = new HorizontalLayout();

        Span valueSpan = new Span(Integer.toString(value));
        valueSpan.getElement().getThemeList().add("badge contrast");
        valueSpan.getElement().getStyle().set("font-weight", "bold");

        Label statLabel = new Label(name);

        row.setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        row.setWidth("10em");

        row.add(statLabel, valueSpan);
        return row;
    }

}
