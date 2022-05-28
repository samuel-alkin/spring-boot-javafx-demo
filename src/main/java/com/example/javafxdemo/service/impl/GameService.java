package com.example.javafxdemo.service.impl;

import com.example.javafxdemo.entity.Game;
import com.example.javafxdemo.repository.GameRepository;
import com.example.javafxdemo.service.IGameService;
import org.springframework.stereotype.Service;

@Service
public class GameService implements IGameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game createGame(Game game) {
        return gameRepository.save(game);
    }
}
