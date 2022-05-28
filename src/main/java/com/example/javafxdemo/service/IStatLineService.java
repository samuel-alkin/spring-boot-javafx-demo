package com.example.javafxdemo.service;

import com.example.javafxdemo.entity.StatLine;
import com.example.javafxdemo.entity.StatLineProjection;

public interface IStatLineService {

    StatLine createStatLine(StatLine statLine);

    void handleFieldGoalMade(StatLineProjection statLineProjection);

    void handleFieldGoalAttempt(StatLineProjection statLineProjection);
}
