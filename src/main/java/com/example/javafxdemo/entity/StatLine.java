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

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
