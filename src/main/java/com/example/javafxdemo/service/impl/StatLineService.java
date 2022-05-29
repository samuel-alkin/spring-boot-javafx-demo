package com.example.javafxdemo.service.impl;

import com.example.javafxdemo.entity.StatLine;
import com.example.javafxdemo.entity.StatLineProjection;
import com.example.javafxdemo.repository.StatLineRepository;
import com.example.javafxdemo.service.IStatLineService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StatLineService implements IStatLineService {

    private final StatLineRepository statLineRepository;

    public StatLineService(StatLineRepository statLineRepository) {
        this.statLineRepository = statLineRepository;
    }

    @Override
    public StatLine createStatLine(StatLine statLine) {
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleFieldGoalMade(StatLineProjection statLineProjection) {
        StatLine statLine = statLineRepository.getById(statLineProjection.getId());
        statLine.setFieldGoalsMade(statLine.getFieldGoalsMade() + 1);
        statLine.setFieldGoalAttempts(statLine.getFieldGoalAttempts() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleFieldGoalAttempt(StatLineProjection statLineProjection) {
        StatLine statLine = statLineRepository.getById(statLineProjection.getId());
        statLine.setFieldGoalAttempts(statLine.getFieldGoalAttempts() + 1);
        return statLineRepository.save(statLine);
    }

}
