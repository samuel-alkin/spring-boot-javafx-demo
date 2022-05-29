package com.example.javafxdemo.service.impl;

import com.example.javafxdemo.entity.StatLine;
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
    public StatLine handleFieldGoalMade(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setFieldGoalsMade(statLine.getFieldGoalsMade() + 1);
        statLine.setFieldGoalAttempts(statLine.getFieldGoalAttempts() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleFieldGoalAttempt(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setFieldGoalAttempts(statLine.getFieldGoalAttempts() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleThreePointAttempt(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setFieldGoalAttempts(statLine.getFieldGoalAttempts() + 1);
        statLine.setThreePointAttempts(statLine.getThreePointAttempts() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleThreePointMade(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setFieldGoalAttempts(statLine.getFieldGoalAttempts() + 1);
        statLine.setThreePointAttempts(statLine.getThreePointAttempts() + 1);
        statLine.setFieldGoalsMade(statLine.getFieldGoalsMade() + 1);
        statLine.setThreePointMade(statLine.getThreePointMade() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleFreeThrowAttempt(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setFreeThrowAttempts(statLine.getFreeThrowAttempts() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleFreeThrowMade(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setFreeThrowAttempts(statLine.getFreeThrowAttempts() + 1);
        statLine.setFreeThrowsMade(statLine.getFreeThrowsMade() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleAssist(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setAssists(statLine.getAssists() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleDefensiveRebound(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setDefensiveRebounds(statLine.getDefensiveRebounds() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleOffensiveRebound(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setOffensiveRebounds(statLine.getOffensiveRebounds() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleSteal(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setSteals(statLine.getSteals() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleBlock(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setBlocks(statLine.getBlocks() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleTurnover(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setTurnovers(statLine.getTurnovers() + 1);
        return statLineRepository.save(statLine);
    }

    @Override
    @Transactional
    public StatLine handleFoul(Long id) {
        StatLine statLine = statLineRepository.getById(id);
        statLine.setFouls(statLine.getFouls() + 1);
        return statLineRepository.save(statLine);
    }

}
