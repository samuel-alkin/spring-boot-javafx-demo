package com.example.javafxdemo.service;

import com.example.javafxdemo.entity.Player;

import java.util.List;

public interface IPlayerService {

    Player createPlayer(Player player);

    List<Player> getPlayersByTeamId(Long teamId);

}
