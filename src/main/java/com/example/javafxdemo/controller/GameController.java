package com.example.javafxdemo.controller;

import com.example.javafxdemo.entity.*;
import com.example.javafxdemo.service.impl.GameService;
import com.example.javafxdemo.service.impl.PlayerService;
import com.example.javafxdemo.service.impl.StatLineService;
import com.example.javafxdemo.service.impl.TeamService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@FxmlView("/fxml/game.fxml")
public class GameController extends Controller {

    private final TeamService teamService;

    private final PlayerService playerService;

    private final StatLineService statLineService;

    private final GameService gameService;

    @FXML
    public ChoiceBox<Team> choiceBoxTeams;

    @FXML
    public TextField opponentTeamName;

    @FXML
    public DatePicker gameDate;

    @FXML
    public TableView<StatLineProjection> playersTable;

    @FXML
    public Button buttonStartGame;

    public GameController(FxWeaver fxWeaver, TeamService teamService, PlayerService playerService, StatLineService statLineService, GameService gameService) {
        super(fxWeaver);
        this.teamService = teamService;
        this.playerService = playerService;
        this.statLineService = statLineService;
        this.gameService = gameService;
    }

    @FXML
    public void initialize() {

        choiceBoxTeams.setConverter(new StringConverter<>() {
            @Override
            public String toString(Team object) {
                return object.getCity() + " " + object.getName();
            }

            @Override
            public Team fromString(String string) {
                return null;
            }
        });

        ObservableList<Team> observableList = FXCollections.observableList(teamService.getAllTeams());
        choiceBoxTeams.setItems(observableList);
        gameDate.setValue(LocalDate.now());
    }

    @FXML
    public void startGame(ActionEvent actionEvent) {

        Game game = new Game();
        Team team = choiceBoxTeams.getValue();
        game.setTeam(team);
        game.setOpponent(opponentTeamName.getText());
        game.setDate(gameDate.getValue());
        game = gameService.createGame(game);

        choiceBoxTeams.setDisable(true);
        opponentTeamName.setDisable(true);
        gameDate.setDisable(true);
        buttonStartGame.setDisable(true);

        List<Player> players = playerService.getPlayersByTeamId(team.getId());
        List<StatLine> statLines = new ArrayList<>();

        for (Player player : players) {
            StatLine statLine = new StatLine();
            statLine.setPlayer(player);
            statLine.setGame(game);
            statLine = statLineService.createStatLine(statLine);
            statLines.add(statLine);
        }

        ObservableList<StatLineProjection> statLineProjections = FXCollections.observableList(
                statLines.stream()
                        .map(StatLineProjection::fromStatLine)
                        .collect(Collectors.toList())
        );

        playersTable.setItems(statLineProjections);
    }

    @FXML
    public void handleFieldGoalAttempt(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleFieldGoalAttempt(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    @FXML
    public void handleFieldGoalMade(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleFieldGoalMade(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    @FXML
    public void handle3PAttempt(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleThreePointAttempt(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    @FXML
    public void handle3PMade(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleThreePointMade(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleFreeThrowAttempt(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleFreeThrowAttempt(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleFreeThrowMade(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleFreeThrowMade(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleAssist(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleAssist(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleDefensiveRebound(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleDefensiveRebound(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleOffensiveRebound(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleOffensiveRebound(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleSteal(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleSteal(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleBlock(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleBlock(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleTurnover(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleTurnover(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    public void handleFoul(ActionEvent actionEvent) {
        StatLineProjection statLineProjection = playersTable.getSelectionModel().getSelectedItem();
        if (statLineProjection == null) {
            System.out.println("Not selected");
            return;
        }
        StatLine newStatLine = statLineService.handleFoul(statLineProjection.getId());
        statLineProjection.updateProjection(newStatLine);
        playersTable.refresh();
        playersTable.getSelectionModel().clearSelection();
    }

    @FXML
    public void finishGame(ActionEvent actionEvent) {
        changeToMain();
    }
}
