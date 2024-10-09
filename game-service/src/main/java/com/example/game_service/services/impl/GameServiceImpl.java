package com.example.game_service.services.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.commons.exceptions.GameException;
import com.example.game_service.repository.GameRepository;
import com.example.game_service.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game saveGame(Game gameRequest){
        return this.gameRepository.save(gameRequest);
    }

    @Override
    public Game getGameById(String id) {
        return this.gameRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error finding game"));
    }
}
