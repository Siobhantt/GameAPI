package com.example.game_service.controller.impl;

import com.example.game_service.commons.entities.Game;
import com.example.game_service.controller.GameApi;
import com.example.game_service.services.GameService;
import com.example.game_service.services.impl.GameServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//El controller es donde se van a manejar las peticiones

@RestController
@RequestMapping("/games")
public class GameController implements GameApi {
    private final GameService gameService;

    /**
     * Instanciates a new game services
     * @param gameService
     */
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Save game response entity
     * @param game the game
     * @return the response entity
     */
    @Override
    @PostMapping
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        Game gameCreated = this.gameService.saveGame(game);
        return ResponseEntity.ok(gameCreated);
    }

    @Override
    public ResponseEntity<Game> getGameById(String id) {
        return ResponseEntity.ok(this.gameService.getGameById(id));
    }
}
