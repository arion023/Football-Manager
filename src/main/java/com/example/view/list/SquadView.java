package com.example.view.list;

import com.example.model.Player;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.listbox.MultiSelectListBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "squad", layout = AppLayoutBasic.class)
@PageTitle("Squad")
public class SquadView extends HorizontalLayout {

    public SquadView() {
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        add(pitchLayout(), playerListLayout());
    }

    private VerticalLayout pitchLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();

        Image pitchImg = new Image("images/pitch.png", "pitch");
        pitchImg.setWidth("1000px");
        add(pitchImg);

        return verticalLayout;
    }

    private VerticalLayout playerListLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();

        MultiSelectListBox<Player> multiSelectListBox = new MultiSelectListBox<>();
        multiSelectListBox.setItems(getSamplePlayers());
        multiSelectListBox.setRenderer(new ComponentRenderer<>(player -> {
            HorizontalLayout row = new HorizontalLayout();
            row.setAlignItems(Alignment.CENTER);

            Icon icon = new Icon(VaadinIcon.USER);

            Span name = new Span(player.getName() + " " + player.getSurname());
            Span position = new Span(player.getPosition().getPositionName());

            position.getStyle()
                    .set("color", "var(--lumo-secondary-text-color)")
                    .set("font-size", "var(--lumo-font-size-s)");

            VerticalLayout column = new VerticalLayout(name, position);
            column.setPadding(false);
            column.setSpacing(false);

            row.add(icon, column);
            row.getStyle().set("line-height", "var(--lumo-line-height-m)");
            return row;
        }));

        verticalLayout.add(multiSelectListBox);
        return verticalLayout;
    }

    //FIXME Should be deleted later
    private List<Player> getSamplePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1, "Wojciech", "Szczęsny", null, null, null, null, null, Player.Position.GK));
        players.add(new Player(1, "Bartosz", "Bereszyński", null, null, null, null, null, Player.Position.LB));
        players.add(new Player(1, "Kamil", "Glik", null, null, null, null, null, Player.Position.CB));
        players.add(new Player(1, "Jakub", "Kiwior", null, null, null, null, null, Player.Position.CB));
        players.add(new Player(1, "Matty", "Cash", null, null, null, null, null, Player.Position.RB));
        players.add(new Player(1, "Przemysław", "Frankowski", null, null, null, null, null, Player.Position.RM));
        players.add(new Player(1, "Krystian", "Bielik", null, null, null, null, null, Player.Position.CM));
        players.add(new Player(1, "Piotr", "Zieliński", null, null, null, null, null, Player.Position.CM));
        players.add(new Player(1, "Nicola", "Zalewski", null, null, null, null, null, Player.Position.LM));
        players.add(new Player(1, "Arkadiusz", "Milik", null, null, null, null, null, Player.Position.CF));
        players.add(new Player(1, "Robert", "Lewandowski", null, null, null, null, null, Player.Position.CF));
        return players;
    }
}
