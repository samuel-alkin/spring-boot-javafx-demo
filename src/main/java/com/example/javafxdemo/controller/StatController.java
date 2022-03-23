package com.example.javafxdemo.controller;

import com.example.javafxdemo.entity.Stat;
import com.example.javafxdemo.service.IStatService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import static javafx.collections.FXCollections.observableArrayList;

@Component
@FxmlView("/ui.fxml")
public class StatController {

    @FXML
    private ListView<Stat> statList;
    private final IStatService statService;

    public StatController(IStatService statService) {
        this.statService = statService;
    }

    @FXML
    public void initialize() {
        ObservableList<Stat> observableStatList = observableArrayList(statService.getStatList());

        statList.setItems(observableStatList);
    }
}
