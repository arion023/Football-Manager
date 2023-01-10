package com.example.views;

import com.example.controller.database.DatabaseConfig;
import com.example.controller.database.DatabaseController;
import com.example.model.enums.Formation;
import com.example.model.entities.Player;
import com.example.model.enums.Position;
import com.example.model.User;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
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
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.model.utils.CssValues.CSS_FONT_SIZE;

@Route(value = "/squad", layout = AppLayoutBasic.class)
@PageTitle("Squad")
@PermitAll
public class SquadView extends HorizontalLayout {

    private final transient User user;
    private final transient DatabaseController dbController;
    private final Select<Formation> selectFormation = createFormationSelect();

    private final Dialog fullTeamDialog = new Dialog();

    private final Dialog positionsDialog = new Dialog();

    private GridListDataView<Player> firstSquadData;
    private GridListDataView<Player> substitutesData;

    @Autowired
    public SquadView(User user, DatabaseController dbController) {
        this.user = user;
        this.dbController = dbController;
        setSizeFull();
        setDefaultVerticalComponentAlignment(Alignment.CENTER);
        ArrayList<Player> clubPlayers = user.getSubstitutes();

        if (user.getFirstSquad().isEmpty()) { //TODO load at app start
            user.setFirstSquad(getFirstSquadWithFormation(clubPlayers));
            user.getSubstitutes().removeAll(user.getFirstSquad());
        }

        configureDialogs();
        var playersLayout = playerListLayout(); //Must be called before pitchLayout()
        add(pitchLayout(), playersLayout, fullTeamDialog, positionsDialog);
    }

    @Override
    protected void onDetach(DetachEvent detachEvent) {
        String query = "UPDATE " + DatabaseConfig.USERS_TABLE_NAME + " SET FORMATION_ID = " + user.getFormationId() + " WHERE USER_ID = " + user.getId();
        dbController.updateDatabase(query);
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

    private void configureDialogs() {
        Button fullTeamButton = new Button("Close");
        fullTeamButton.addClickListener(event -> fullTeamDialog.close());
        fullTeamDialog.getFooter().add(fullTeamButton);
        fullTeamDialog.setHeaderTitle("First squad is full!");
        fullTeamDialog.add(new Span("You already have 11 players in your first squad."));

        Button positionsButton = new Button("Close");
        positionsButton.addClickListener(event -> positionsDialog.close());
        positionsDialog.getFooter().add(positionsButton);
        positionsDialog.setHeaderTitle("Position line is full!");
        positionsDialog.add(new Span("You already have enough players for this position line. Try to change formation."));
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

        vL.add(getPlayersLineLayout(getPlayersFromPositions(user.getFirstSquad(), Position.getForwardPositions()), formation.getForwardsNumber()));
        vL.add(getPlayersLineLayout(getPlayersFromPositions(user.getFirstSquad(), Position.getMidfieldPositions()), formation.getMidfieldersNumber()));
        vL.add(getPlayersLineLayout(getPlayersFromPositions(user.getFirstSquad(), Position.getBackPositions()), formation.getDefendersNumber()));
        vL.add(getPlayersLineLayout(getPlayersFromPositions(user.getFirstSquad(), List.of(Position.GK)), 1));

        return vL;
    }

    private ArrayList<Player> getPlayersFromPositions(List<Player> players, List<Position> positions) {
        return players.stream()
                .filter(p -> positions.contains(p.getPosition()))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private VerticalLayout getPlayerImageWithSurname(Player player) {
        VerticalLayout vL = new VerticalLayout();
        vL.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        String shirtImageName = player.getPosition().equals(Position.GK) ? "gk_shirt.png" : "shirt.png";
        Image shirt = new Image("images/" + shirtImageName, "shirt");

        shirt.setHeight(100, Unit.PIXELS);
        Span surname = new Span(player.getSurname());
        surname.getStyle().set("font-weight", "bold");
        surname.getStyle().set(CSS_FONT_SIZE, "1.1rem");

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
        firstSquadData = firstSquadGrid.setItems(user.getFirstSquad());
        substitutesData = substitutesGrid.setItems(user.getSubstitutes());

        //TODO buttony wychodzą poza grid
        firstSquadGrid.addColumn(new NativeButtonRenderer<>("Remove player",
                player -> {
                    firstSquadData.removeItem(player);
                    substitutesData.addItem(player);
                    this.replace(this.getComponentAt(0), pitchLayout());
                }));

        substitutesGrid.addColumn(new NativeButtonRenderer<>("Add player",
                player -> {
                    if (user.getFirstSquad().size() == 11) {
                        fullTeamDialog.open();
                    } else if (checkPositions(player)) {
                        positionsDialog.open();
                    } else {
                        substitutesData.removeItem(player);
                        firstSquadData.addItem(player);
                        this.replace(this.getComponentAt(0), pitchLayout());
                    }
                }));

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

        return (Position.GK.equals(position) && goalkeeperInSquad == 1)
                || (Position.getBackPositions().contains(position) && backsInSquad == formation.getDefendersNumber())
                || (Position.getMidfieldPositions().contains(position) && midfieldersInSquad == formation.getMidfieldersNumber())
                || (Position.getForwardPositions().contains(position) && forwardsInSquad == formation.getForwardsNumber());
    }

    private long countPlayersInPositions(List<Position> positions) {
        return user.getFirstSquad().stream()
                .filter(player -> positions.contains(player.getPosition()))
                .count();
    }

    private Select<Formation> createFormationSelect() {
        Select<Formation> select = new Select<>();
        select.setLabel("Formation");
        select.setItemLabelGenerator(Formation::getName);
        select.setItems(Formation.values());
        select.setValue(Formation.getFormationById(user.getFormationId()));
        select.addValueChangeListener(selectFormationComponentValueChangeEvent -> {
            this.replace(this.getComponentAt(0), pitchLayout());
            user.setFormationId(selectFormationComponentValueChangeEvent.getValue().getId());
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
                .setHeader("Pos")
                .setAutoWidth(true)
                .setFlexGrow(0)
                .setSortable(true);
        grid.addColumn(player -> player.getStatistics() == null ? "" : player.getStatistics().getOverall())
                .setHeader("OV")
                .setAutoWidth(true)
                .setSortable(true);
        grid.addColumn(player -> player.getStatistics() == null ? "" : player.getStatistics().getPace())
                .setHeader("PAC")
                .setAutoWidth(true);
        grid.addColumn(player -> player.getStatistics() == null ? "" : player.getStatistics().getShooting())
                .setHeader("SHO")
                .setAutoWidth(true);
        grid.addColumn(player -> player.getStatistics() == null ? "" : player.getStatistics().getPassing())
                .setHeader("PAS")
                .setAutoWidth(true);
        grid.addColumn(player -> player.getStatistics() == null ? "" : player.getStatistics().getDribbling())
                .setHeader("DRI")
                .setAutoWidth(true);
        grid.addColumn(player -> player.getStatistics() == null ? "" : player.getStatistics().getDefence())
                .setHeader("DEF")
                .setAutoWidth(true);
        grid.addColumn(player -> player.getStatistics() == null ? "" : player.getStatistics().getPhysically())
                .setHeader("PHY")
                .setAutoWidth(true);
        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        return grid;
    }
}
