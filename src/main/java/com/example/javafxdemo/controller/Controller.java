package com.example.javafxdemo.controller;

import com.example.javafxdemo.FXApplication;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.context.ApplicationListener;

public class Controller implements ApplicationListener<FXApplication.StageReadyEvent> {

    protected final FxWeaver fxWeaver;

    protected Stage stage;

    public Controller(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(FXApplication.StageReadyEvent event) {
        this.stage = event.getStage();
    }

    protected void changeToMain() {
        stage.setScene(new Scene(fxWeaver.loadView(MainController.class), 800, 600));
        stage.show();
    }

    protected void changeToGame() {
        stage.setScene(new Scene(fxWeaver.loadView(GameController.class), 800, 600));
        stage.show();
    }

    protected void changeToTeam() {
        stage.setScene(new Scene(fxWeaver.loadView(TeamController.class), 800, 600));
        stage.show();
    }

}
