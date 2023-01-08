package com.example.views;

import com.example.controller.database.DatabaseController;
import com.example.model.Formation;
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
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.NativeButtonRenderer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Route(value = "/squad", layout = AppLayoutBasic.class)
@PageTitle("Squad")
@PreserveOnRefresh //Czy to będzie git?
//TODO zrobić żeby się nie renderowała za każdym razem od nowa
@PermitAll
public class SquadView extends HorizontalLayout {

    private ArrayList<Player> firstSquad;
    private ArrayList<Player> substitutes; //Must be mutable list i.e ArrayList

    private Select<Formation> selectFormation = createFormationSelect();

    private GridListDataView<Player> firstSquadData;
    private GridListDataView<Player> substitutesData;
    private DatabaseController dbController;

    public SquadView(DatabaseController dbController) {
        this.dbController = dbController;
        setSizeFull();
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        ArrayList<Player> clubPlayers = new ArrayList<>(Player.getPlayersByClub(4248, this.dbController));//TODO pobrać zawodników z user.club
//        firstSquad = new ArrayList<>(clubPlayers.subList(0, 11));
        firstSquad = getFirstSquadWithFormation(clubPlayers);
        substitutes = new ArrayList<>(clubPlayers.subList(15, 25));
        var playersLayout = playerListLayout(); //Must be called before pitchLayout()
        add(pitchLayout(), playersLayout);
    }

    private ArrayList<Player> getFirstSquadWithFormation(List<Player> clubPlayers) {
        Formation formation = selectFormation.getValue();
        ArrayList<Player> firstSquadList = new ArrayList<>();

        firstSquadList.addAll(getPlayersFromPositions(clubPlayers, List.of(Position.GK)));
        firstSquadList.addAll(getPlayersFromPositions(clubPlayers, Position.getForwardPositions()).subList(0, formation.getForwardsNumber()));
        firstSquadList.addAll(getPlayersFromPositions(clubPlayers, Position.getMidfieldPositions()).subList(0, formation.getMidfieldersNumber()));
        firstSquadList.addAll(getPlayersFromPositions(clubPlayers, Position.getBackPositions()).subList(0, formation.getDefendersNumber()));

        return firstSquadList;
    }

    private VerticalLayout pitchLayout() {
        VerticalLayout vL = new VerticalLayout();
        vL.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        vL.setWidth(100, Unit.PERCENTAGE);
        vL.setHeight(90, Unit.PERCENTAGE);
        vL.setMinWidth(200, Unit.PIXELS);
        vL.getStyle().set("background-image", "url(images/pitch_vertical.png)");
        vL.getStyle().set("background-size", "contain");
        vL.getStyle().set("background-repeat", "no-repeat");
        vL.getStyle().set("background-position", "center");

        Formation formation = selectFormation.getValue();

        vL.add(getPlayersLineLayout(getPlayersFromPositions(firstSquad, Position.getForwardPositions()), formation.getForwardsNumber()));
        vL.add(getPlayersLineLayout(getPlayersFromPositions(firstSquad, Position.getMidfieldPositions()), formation.getMidfieldersNumber()));
        vL.add(getPlayersLineLayout(getPlayersFromPositions(firstSquad, Position.getBackPositions()), formation.getDefendersNumber()));
        vL.add(getPlayersLineLayout(getPlayersFromPositions(firstSquad, List.of(Position.GK)), 1));

        return vL;
    }

    private ArrayList<Player> getPlayersFromPositions(List<Player> players, List<Position> positions) {
        return players.stream() //TODO wybierać dobrych zawodników
                .filter(p -> positions.contains(p.getPosition()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private VerticalLayout getPlayerImageWithSurname(Player player) {
        VerticalLayout vL = new VerticalLayout();
        vL.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        Image shirt = new Image("images/shirt.png", "shirt");//TODO dać bramkarzowi inną koszulkę

        shirt.setHeight(100, Unit.PIXELS);
        Span surname = new Span(player.getSurname());
        surname.getStyle().set("font-weight", "bold");
        surname.getStyle().set("font-size", "1.1rem");

        vL.add(shirt, surname);
        return vL;
    }

    private HorizontalLayout getPlayersLineLayout(ArrayList<Player> players, int playersNo) {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        while (players.size() > playersNo) {
            var player = players.get(0);
            players.remove(0);
            firstSquadData.removeItem(player);
            substitutesData.addItem(player);
        }
        for (var player : players) {
            horizontalLayout.add(getPlayerImageWithSurname(player));
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
        firstSquadData = firstSquadGrid.setItems(firstSquad);
        substitutesData = substitutesGrid.setItems(substitutes);

        firstSquadGrid.addColumn(new NativeButtonRenderer<>("Remove player",
                player -> {
                    firstSquadData.removeItem(player);
                    substitutesData.addItem(player);
                    this.replace(this.getComponentAt(0), pitchLayout());
                }));

        substitutesGrid.addColumn(new NativeButtonRenderer<>("Add player",
                player -> {
                    if (firstSquad.size() == 11) {
                        //TODO komunikat
                    } else if (checkPositions(player)) {
                        //TODO komunikat
                    } else {
                        substitutesData.removeItem(player);
                        firstSquadData.addItem(player);
                        this.replace(this.getComponentAt(0), pitchLayout());
                    }
                }));

//        vL.setFlexGrow(1, firstSquadGrid); TODO rozciągnąć grid pierwszego składu
        vL.add(selectFormation, firstSquadGrid, substitutesGrid);
        return vL;
    }

    private boolean checkPositions(Player player) {
        Formation formation = selectFormation.getValue();
        var position = player.getPosition();
        var goalkeeperInSquad = countPlayersInPositions(Position.getGoalkeepersPositions());
        var backsInSquad = countPlayersInPositions(Position.getBackPositions());
        var midfieldersInSquad = countPlayersInPositions(Position.getMidfieldPositions());
        var forwardsInSquad = countPlayersInPositions(Position.getForwardPositions());
        //TODO refactor
        if (Position.GK.equals(position) && goalkeeperInSquad == 1) {
            return true;
        } else if (Position.getBackPositions().contains(position) && backsInSquad == formation.getDefendersNumber()) {
            return true;
        } else if (Position.getMidfieldPositions().contains(position) && midfieldersInSquad == formation.getMidfieldersNumber()) {
            return true;
        } else if (Position.getForwardPositions().contains(position) && forwardsInSquad == formation.getForwardsNumber()) {
            return true;
        }

        return false;
    }

    private long countPlayersInPositions(List<Position> positions) {
        return firstSquad.stream()
                .filter(player -> positions.contains(player.getPosition()))
                .count();
    }

    private Select<Formation> createFormationSelect() {
        Select<Formation> select = new Select<>();
        select.setLabel("Formation");
        select.setItemLabelGenerator(Formation::getName);
        select.setItems(Formation.values());
        select.setValue(Formation.F_442);
        select.addValueChangeListener(selectFormationComponentValueChangeEvent -> {
            this.replace(this.getComponentAt(0), pitchLayout());
        });
        return select;
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
                .setFlexGrow(0)
                .setSortable(true);
        //TODO dodać statystyki
        //        firstSquadGrid.addColumn(Player::getStatistics).setHeader("Statystyki")
        //                .setAutoWidth(true).setFlexGrow(0);
        return grid;
    }
}
