package com.example.javafxdemo.service;

import com.example.javafxdemo.entity.StatLine;
import com.example.javafxdemo.entity.StatLineProjection;

public interface IStatLineService {

    StatLine createStatLine(StatLine statLine);

    StatLine handleFieldGoalMade(StatLineProjection statLineProjection);

    StatLine handleFieldGoalAttempt(StatLineProjection statLineProjection);
}
