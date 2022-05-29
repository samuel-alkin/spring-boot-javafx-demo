package com.example.javafxdemo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StatLine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int fieldGoalAttempts;

    private int fieldGoalsMade;

    private int threePointAttempts;

    private int threePointMade;

    private int freeThrowAttempts;

    private int freeThrowsMade;

    private int assists;

    private int defensiveRebounds;

    private int offensiveRebounds;

    private int steals;

    private int blocks;

    private int turnovers;

    private int fouls;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
