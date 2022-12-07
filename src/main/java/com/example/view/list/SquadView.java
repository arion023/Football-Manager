package com.example.view.list;

import com.example.model.Player;
import com.example.model.Player.Position;
import com.vaadin.flow.component.Unit;
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
        setSizeFull();
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        var players = getSamplePlayers();
//        var players = Player.getAllPlayersFromDB();
        add(pitchLayout(players), playerListLayout(players));
    }

    private VerticalLayout pitchLayout(List<Player> players) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        verticalLayout.setWidth(100, Unit.PERCENTAGE);
        verticalLayout.setHeight(90, Unit.PERCENTAGE);
        verticalLayout.setMinWidth(200, Unit.PIXELS);
        verticalLayout.getStyle().set("background-image", "url(images/pitch.png)");
        verticalLayout.getStyle().set("background-size", "contain");
        verticalLayout.getStyle().set("background-repeat", "no-repeat");
        verticalLayout.getStyle().set("background-position", "center");

        verticalLayout.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.LF, Position.CF, Position.RF)), 2));
        verticalLayout.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.LM, Position.CM, Position.RM)), 4));
        verticalLayout.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.LB, Position.CB, Position.RB)), 4));
        verticalLayout.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.GK)), 1));

        return verticalLayout;
    }

    private List<Player> getPlayersFromPosition(List<Player> players, List<Position> positions) {
        return players.stream()
                .filter(p -> positions.contains(p.getPosition()))
                .toList();
    }

    private VerticalLayout getPlayerImageWithSurname(Player player) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Image shirt = new Image("images/shirt.png", "shirt");

        shirt.setHeight(100, Unit.PIXELS);
        Span surname = new Span(player.getSurname());
        surname.getStyle().set("font-weight", "bold");
        surname.getStyle().set("font-size", "1.1rem");

        verticalLayout.add(shirt, surname);
        return verticalLayout;
    }

    private HorizontalLayout getPlayersLineLayout(List<Player> players, int players_no) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
//        for (var player : players) {
//            horizontalLayout.add(getPlayerImageWithSurname(player));
//        }
        for (int i = 0; i < players_no; i++) {
            horizontalLayout.add(getPlayerImageWithSurname(players.get(i)));
        }
        horizontalLayout.getStyle().set("padding-top", "15px");

        return horizontalLayout;
    }


    private VerticalLayout playerListLayout(List<Player> players) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setWidth(100, Unit.PERCENTAGE);
        verticalLayout.setHeight(100, Unit.PERCENTAGE);
        verticalLayout.setMinWidth(300, Unit.PIXELS);
        verticalLayout.getStyle().set("overflow-y", "auto"); //Scroll

        MultiSelectListBox<Player> multiSelectListBox = new MultiSelectListBox<>();
        multiSelectListBox.setWidth(100, Unit.PERCENTAGE);
        multiSelectListBox.setItems(players);
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
        players.add(new Player(1, "Wojciech", "Szczęsny", null, null, null, null, null, Position.GK));
        players.add(new Player(2, "Bartosz", "Bereszyński", null, null, null, null, null, Position.LB));
        players.add(new Player(3, "Kamil", "Glik", null, null, null, null, null, Position.CB));
        players.add(new Player(4, "Jakub", "Kiwior", null, null, null, null, null, Position.CB));
        players.add(new Player(5, "Matty", "Cash", null, null, null, null, null, Position.RB));
        players.add(new Player(6, "Przemysław", "Frankowski", null, null, null, null, null, Position.RM));
        players.add(new Player(7, "Krystian", "Bielik", null, null, null, null, null, Position.CM));
        players.add(new Player(8, "Piotr", "Zieliński", null, null, null, null, null, Position.CM));
        players.add(new Player(9, "Nicola", "Zalewski", null, null, null, null, null, Position.LM));
        players.add(new Player(10, "Arkadiusz", "Milik", null, null, null, null, null, Position.CF));
        players.add(new Player(11, "Robert", "Lewandowski", null, null, null, null, null, Position.CF));
        players.add(new Player(12, "Łukasz", "Skorupski", null, null, null, null, null, Position.GK));
        players.add(new Player(13, "Kamil", "Grabara", null, null, null, null, null, Position.GK));
        players.add(new Player(14, "Grzegorz", "Krychowiak", null, null, null, null, null, Position.CM));
        players.add(new Player(15, "Artur", "Jędrzejczyk", null, null, null, null, null, Position.CB));
        players.add(new Player(16, "Jakub", "Kamiński", null, null, null, null, null, Position.RM));
        players.add(new Player(17, "Michał", "Skóraś", null, null, null, null, null, Position.LM));
        players.add(new Player(18, "Kamil", "Grosicki", null, null, null, null, null, Position.LM));
        players.add(new Player(19, "Krzysztof", "Piątek", null, null, null, null, null, Position.CF));
        players.add(new Player(20, "Karol", "Świderski", null, null, null, null, null, Position.CF));
        players.add(new Player(21, "Kamil", "Wieteska", null, null, null, null, null, Position.CB));
        players.add(new Player(22, "Sebastian", "Szymański", null, null, null, null, null, Position.CM));
        return players;
    }
}
