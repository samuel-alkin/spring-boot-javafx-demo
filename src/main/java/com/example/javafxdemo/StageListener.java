package com.example.javafxdemo;

import com.example.javafxdemo.controller.StatController;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


@Component
public class StageListener implements ApplicationListener<FXApplication.StageReadyEvent> {

    private final String applicationTitle;
    private final FxWeaver fxWeaver;

    public StageListener(@Value("${spring.application.ui.title}") String applicationTitle,
                         FxWeaver fxWeaver) {
        this.applicationTitle = applicationTitle;
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(FXApplication.StageReadyEvent event) {
        Stage stage = event.getStage();
        stage.setScene(new Scene(fxWeaver.loadView(StatController.class), 800, 600));
        stage.setTitle(applicationTitle);
        stage.show();
    }

}
