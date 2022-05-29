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

    public static StatLineProjection fromStatLine(StatLine statLine) {
        StatLineProjection statLineProjection = new StatLineProjection();
        statLineProjection.setId(statLine.getId());
        statLineProjection.setNumber(statLine.getPlayer().getJerseyNumber());
        statLineProjection.setFirstName(statLine.getPlayer().getFirstName());
        statLineProjection.setLastName(statLine.getPlayer().getLastName());
        statLineProjection.setFieldGoalAttempts(statLine.getFieldGoalAttempts());
        statLineProjection.setFieldGoalsMade(statLine.getFieldGoalsMade());
        return statLineProjection;
    }

    public void updateProjection(StatLine statLine) {
        this.setId(statLine.getId());
        this.setNumber(statLine.getPlayer().getJerseyNumber());
        this.setFirstName(statLine.getPlayer().getFirstName());
        this.setLastName(statLine.getPlayer().getLastName());
        this.setFieldGoalAttempts(statLine.getFieldGoalAttempts());
        this.setFieldGoalsMade(statLine.getFieldGoalsMade());
    }

}
