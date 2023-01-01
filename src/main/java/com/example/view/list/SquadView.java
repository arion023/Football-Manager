package com.example.view.list;

import com.example.model.Player;
import com.example.model.Player.Position;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route(value = "squad", layout = AppLayoutBasic.class)
@PageTitle("Squad")
public class SquadView extends HorizontalLayout {

    private ArrayList<Player> firstSquad;
    private ArrayList<Player> substitutes; //Must be mutable list i.e ArrayList

    public SquadView() {
        setSizeFull();
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
//        var players = getSamplePlayers();
        var players = Player.getAllPlayersFromDB().subList(0, 50);
        firstSquad = new ArrayList<>(players.subList(0, 11));
        substitutes = new ArrayList<>(players.subList(15, 25));

        add(pitchLayout(players), playerListLayout());
    }

    private VerticalLayout pitchLayout(List<Player> players) {
        VerticalLayout vL = new VerticalLayout();
        vL.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        vL.setWidth(100, Unit.PERCENTAGE);
        vL.setHeight(90, Unit.PERCENTAGE);
        vL.setMinWidth(200, Unit.PIXELS);
        vL.getStyle().set("background-image", "url(images/pitch.png)");
        vL.getStyle().set("background-size", "contain");
        vL.getStyle().set("background-repeat", "no-repeat");
        vL.getStyle().set("background-position", "center");

        vL.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.LF, Position.CF, Position.RF)), 2));
        vL.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.LM, Position.CM, Position.RM)), 4));
        vL.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.LB, Position.CB, Position.RB)), 4));
        vL.add(getPlayersLineLayout(getPlayersFromPosition(players, List.of(Position.GK)), 1));

        return vL;
    }

    private List<Player> getPlayersFromPosition(List<Player> players, List<Position> positions) {
        return players.stream()
                .filter(p -> positions.contains(p.getPosition()))
                .toList();
    }

    private VerticalLayout getPlayerImageWithSurname(Player player) {
        VerticalLayout vL = new VerticalLayout();
        vL.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Image shirt = new Image("images/shirt.png", "shirt");

        shirt.setHeight(100, Unit.PIXELS);
        Span surname = new Span(player.getSurname());
        surname.getStyle().set("font-weight", "bold");
        surname.getStyle().set("font-size", "1.1rem");

        vL.add(shirt, surname);
        return vL;
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

    private VerticalLayout playerListLayout() {
        VerticalLayout vL = new VerticalLayout();
        vL.setWidth(100, Unit.PERCENTAGE);
        vL.setHeight(100, Unit.PERCENTAGE);
        vL.setMinWidth(300, Unit.PIXELS);
        vL.getStyle().set("overflow-y", "auto"); //Scroll

        Grid<Player> firstSquadGrid = createPlayersGrid();
        Grid<Player> substitutesGrid = createPlayersGrid();
        GridListDataView<Player> dataView1 = firstSquadGrid.setItems(firstSquad);
        GridListDataView<Player> dataView2 = substitutesGrid.setItems(substitutes);

        firstSquadGrid.addColumn(new NativeButtonRenderer<>("Remove player",
                player -> {
                    dataView1.removeItem(player);
                    dataView2.addItem(player);

                }));

        substitutesGrid.addColumn(new NativeButtonRenderer<>("Add player",
                player -> {
                    if (firstSquad.size() == 11) {
                        //TODO komunikat
                    } else {
                        dataView2.removeItem(player);
                        dataView1.addItem(player);
                    }
                }));


        vL.add(firstSquadGrid, substitutesGrid);
        return vL;
    }

    private Grid<Player> createPlayersGrid() {
        Grid<Player> grid = new Grid<>(Player.class, false);
        grid.addColumn(new ComponentRenderer<>(e -> new Icon(VaadinIcon.USER)))
                .setAutoWidth(true)
                .setFlexGrow(0);
        grid.addColumn(Player::getName)
                .setHeader("Imie")
                .setAutoWidth(true)
                .setFlexGrow(0);
        grid.addColumn(Player::getSurname)
                .setHeader("Nazwisko")
                .setAutoWidth(true)
                .setFlexGrow(0);
        grid.addColumn(Player::getPosition)
                .setHeader("Pozycja")
                .setAutoWidth(true)
                .setFlexGrow(0);
        //        firstSquadGrid.addColumn(Player::getStatistics).setHeader("Statystyki")
        //                .setAutoWidth(true).setFlexGrow(0);
        return grid;
    }

    private Renderer<Player> createRemoveButton() {
        return LitRenderer.<Player>of(
                        "<vaadin-button>Usuń</vaadin-button>")
                .withFunction("handleClick",
                        player -> {
                            substitutes.add(player);
                            firstSquad.remove(player);
                        });
    }

    private Renderer<Player> createAddButton() {
        return LitRenderer.<Player>of(
                        "<vaadin-button>Dodaj</vaadin-button>").
                withFunction("handleClick",
                        player -> {
                            if (firstSquad.size() == 11) {
                                //TODO wyświetlić komunikat
                            } else {
                                firstSquad.add(player);
                                substitutes.remove(player);
                            }
                        });
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
