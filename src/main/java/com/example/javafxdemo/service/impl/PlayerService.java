package com.example.javafxdemo.service.impl;

import com.example.javafxdemo.entity.Player;
import com.example.javafxdemo.repository.PlayerRepository;
import com.example.javafxdemo.service.IPlayerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService implements IPlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player createPlayer(Player player) {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getPlayersByTeamId(Long teamId) {
        return playerRepository.findAllByTeamId(teamId);
    }
}
