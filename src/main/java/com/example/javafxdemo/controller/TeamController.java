package com.example.javafxdemo.controller;

import com.example.javafxdemo.entity.Player;
import com.example.javafxdemo.entity.Team;
import com.example.javafxdemo.service.IPlayerService;
import com.example.javafxdemo.service.ITeamService;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/fxml/team.fxml")
public class TeamController extends Controller {

    private final ITeamService teamService;
    private final IPlayerService playerService;

    @FXML
    public TextField teamName;

    @FXML
    public TextField teamCity;

    @FXML
    public TextField newFirstName;

    @FXML
    public TextField newLastName;

    @FXML
    public Spinner<Integer> newNumber;

    @FXML
    public TableView<Player> playersTable;

    public TeamController(FxWeaver fxWeaver, ITeamService teamService, IPlayerService playerService) {
        super(fxWeaver);
        this.teamService = teamService;
        this.playerService = playerService;
    }

    @FXML
    public void addPlayerToTable(ActionEvent actionEvent) {
        ObservableList<Player> data = playersTable.getItems();
        Player toAdd = new Player();
        toAdd.setFirstName(newFirstName.getText());
        toAdd.setLastName(newLastName.getText());
        toAdd.setJerseyNumber(newNumber.getValue());
        data.add(toAdd);

        newFirstName.setText("");
        newLastName.setText("");
        newNumber.getEditor().setText("");
        newNumber.setPromptText("Number");
    }

    @FXML
    public void createNewTeam(ActionEvent actionEvent) {
        Team team = new Team();
        team.setName(teamName.getText());
        team.setCity(teamCity.getText());
        team = teamService.createTeam(team);

        ObservableList<Player> players = playersTable.getItems();
        for (Player player : players) {
            player.setTeam(team);
            playerService.createPlayer(player);
        }

        changeToMain();

    }
}
