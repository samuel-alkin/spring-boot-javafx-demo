package com.example.javafxdemo.service;

import com.example.javafxdemo.entity.StatLine;
import com.example.javafxdemo.entity.StatLineProjection;

public interface IStatLineService {

    StatLine createStatLine(StatLine statLine);

    StatLine handleFieldGoalMade(Long id);

    StatLine handleFieldGoalAttempt(Long id);

    StatLine handleThreePointAttempt(Long id);

    StatLine handleThreePointMade(Long id);

    StatLine handleFreeThrowAttempt(Long id);

    StatLine handleFreeThrowMade(Long id);

    StatLine handleAssist(Long id);

    StatLine handleDefensiveRebound(Long id);

    StatLine handleOffensiveRebound(Long id);

    StatLine handleSteal(Long id);

    StatLine handleBlock(Long id);

    StatLine handleTurnover(Long id);

    StatLine handleFoul(Long id);
    
}
