package br.dev.celso.games.service;

import br.dev.celso.games.model.Game;
import br.dev.celso.games.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game insertGame(Game game) {
        return gameRepository.save(game);
    }

    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    public Game getGameById(Long id) {
        Optional<Game> gameOptional = gameRepository.findById(id);

        return gameOptional.orElse(null);

    }

}
