package com.example.javafxdemo;

import com.example.javafxdemo.controller.MainController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class StageListener implements ApplicationListener<FXApplication.StageReadyEvent> {
    private final FxWeaver fxWeaver;

    public StageListener(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(FXApplication.StageReadyEvent event) {
        Stage stage = event.getStage();
        stage.setScene(new Scene(fxWeaver.loadView(MainController.class), 800, 600));
        stage.setTitle("StatApp");
        stage.show();
    }

}
