package com.example.javafxdemo.entity;

import lombok.Data;

@Data
public class StatLineProjection {

    private Long id;

    private int number;

    private String firstName;

    private String lastName;

    private int fieldGoalAttempts;

    private int fieldGoalsMade;

    private double fieldGoalPercentage;

    private int threePointAttempts;

    private int threePointMade;

    private double threePointPercentage;

    private int freeThrowAttempts;

    private int freeThrowsMade;

    private double freeThrowPercentage;

    private int assists;

    private int defensiveRebounds;

    private int offensiveRebounds;

    private int rebounds;

    private int steals;

    private int blocks;

    private int turnovers;

    private int fouls;

    private int points;

    private double efficiency;

    public static StatLineProjection fromStatLine(StatLine statLine) {
        StatLineProjection projection = new StatLineProjection();
        projection.setId(statLine.getId());
        projection.setNumber(statLine.getPlayer().getJerseyNumber());
        projection.setFirstName(statLine.getPlayer().getFirstName());
        projection.setLastName(statLine.getPlayer().getLastName());
        projection.setFieldGoalAttempts(statLine.getFieldGoalAttempts());
        projection.setFieldGoalsMade(statLine.getFieldGoalsMade());
        projection.setFieldGoalPercentage(calculateFieldGoalPercentage(statLine));
        projection.setThreePointAttempts(statLine.getThreePointAttempts());
        projection.setThreePointMade(statLine.getThreePointMade());
        projection.setThreePointPercentage(calculateThreePointPercentage(statLine));
        projection.setFreeThrowAttempts(statLine.getFreeThrowAttempts());
        projection.setFreeThrowsMade(statLine.getFreeThrowsMade());
        projection.setFreeThrowPercentage(calculateFreeThrowPercentage(statLine));
        projection.setAssists(statLine.getAssists());
        projection.setDefensiveRebounds(statLine.getDefensiveRebounds());
        projection.setOffensiveRebounds(statLine.getOffensiveRebounds());
        projection.setRebounds(statLine.getDefensiveRebounds() + statLine.getOffensiveRebounds());
        projection.setSteals(statLine.getSteals());
        projection.setBlocks(statLine.getBlocks());
        projection.setTurnovers(statLine.getTurnovers());
        projection.setFouls(statLine.getFouls());
        projection.setPoints(calculatePoints(statLine));
        projection.setEfficiency(calculateEfficiency(statLine));
        return projection;
    }

    private static double calculateEfficiency(StatLine statLine) {
        // (Points + Rebounds + Assists + Steals + Blocks + Fouls Drawn) - (Missed Field Goals + Missed Free Throws + Turnovers + Shots Rejected + Fouls Committed)
        return (calculatePoints(statLine) + statLine.getDefensiveRebounds() + statLine.getOffensiveRebounds() + statLine.getAssists() + statLine.getSteals() + statLine.getBlocks())
                - ((statLine.getFieldGoalAttempts() - statLine.getFieldGoalsMade()) + (statLine.getFreeThrowAttempts() - statLine.getFreeThrowsMade()) + statLine.getTurnovers() + statLine.getFouls());
    }

    private static int calculatePoints(StatLine statLine) {
        return statLine.getFreeThrowAttempts() + statLine.getFieldGoalsMade() * 2 + statLine.getThreePointMade() * 3;
    }

    public void updateProjection(StatLine statLine) {
        this.setId(statLine.getId());
        this.setNumber(statLine.getPlayer().getJerseyNumber());
        this.setFirstName(statLine.getPlayer().getFirstName());
        this.setLastName(statLine.getPlayer().getLastName());
        this.setFieldGoalAttempts(statLine.getFieldGoalAttempts());
        this.setFieldGoalsMade(statLine.getFieldGoalsMade());
        this.setFieldGoalPercentage(calculateFieldGoalPercentage(statLine));
        this.setThreePointAttempts(statLine.getThreePointAttempts());
        this.setThreePointMade(statLine.getThreePointMade());
        this.setThreePointPercentage(calculateThreePointPercentage(statLine));
        this.setFreeThrowAttempts(statLine.getFreeThrowAttempts());
        this.setFreeThrowsMade(statLine.getFreeThrowsMade());
        this.setFreeThrowPercentage(calculateFreeThrowPercentage(statLine));
        this.setAssists(statLine.getAssists());
        this.setDefensiveRebounds(statLine.getDefensiveRebounds());
        this.setOffensiveRebounds(statLine.getOffensiveRebounds());
        this.setRebounds(statLine.getDefensiveRebounds() + statLine.getOffensiveRebounds());
        this.setSteals(statLine.getSteals());
        this.setBlocks(statLine.getBlocks());
        this.setTurnovers(statLine.getTurnovers());
        this.setFouls(statLine.getFouls());
        this.setPoints(calculatePoints(statLine));
        this.setEfficiency(calculateEfficiency(statLine));
    }

    private static double calculateFieldGoalPercentage(StatLine statLine) {
        if (statLine.getFieldGoalAttempts() == 0) {
            return 0.0;
        }
        return statLine.getFieldGoalsMade() * 1.0 / statLine.getFieldGoalAttempts();
    }

    private static double calculateThreePointPercentage(StatLine statLine) {
        if (statLine.getThreePointAttempts() == 0) {
            return 0.0;
        }
        return statLine.getThreePointMade() * 1.0 / statLine.getThreePointAttempts();
    }

    private static double calculateFreeThrowPercentage(StatLine statLine) {
        if (statLine.getFreeThrowAttempts() == 0) {
            return 0.0;
        }
        return statLine.getFreeThrowsMade() * 1.0 / statLine.getFreeThrowAttempts();
    }

}
