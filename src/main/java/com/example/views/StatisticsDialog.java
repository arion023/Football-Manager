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

    StatisticsDialog (){
        this.setHeaderTitle("Statistics");
        this.configLayout();
    }

    private void configLayout() {
        VerticalLayout dialogLayout = new VerticalLayout();
        this.statisticsContent = new HorizontalLayout(firstColumn, secondColumn);


        this.overallLayout.add(new Label("Overall: "), overall);
        this.overallLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        this.overallLayout.setFlexGrow(1);

        Button closeButton = new Button("Close", buttonClickEvent -> { this.close(); });

        dialogLayout.add(this.playerName, overallLayout, statisticsContent, closeButton);
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

        Label statLabel = new Label(name);
        statLabel.setWidth("25em");

        row.add(new Label(name), valueSpan);
        return row;
    }

}
