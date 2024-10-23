package br.dev.celso.games.controller;

import br.dev.celso.games.model.Game;
import br.dev.celso.games.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    @ResponseStatus(HttpStatus.CREATED)
    public Game insertGame(@RequestBody Game game) {
        return gameService.insertGame(game);
    }

    @GetMapping("/games")
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id) {
        if (gameService.getGameById(id) != null) {
            return ResponseEntity.ok(gameService.getGameById(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
