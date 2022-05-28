package com.example.javafxdemo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

@Component
@FxmlView("/fxml/main.fxml")
public class MainController extends Controller {

    public MainController(FxWeaver fxWeaver) {
        super(fxWeaver);
    }

    @FXML
    public void createTeam(ActionEvent actionEvent) {
        changeToTeam();
    }

    @FXML
    public void createGame(ActionEvent actionEvent) {
        changeToGame();
    }

}
