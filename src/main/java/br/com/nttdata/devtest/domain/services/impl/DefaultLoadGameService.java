package br.com.nttdata.devtest.domain.services.impl;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.domain.repository.GameRepository;
import br.com.nttdata.devtest.domain.services.LoadGameService;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;
import br.com.nttdata.devtest.main.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultLoadGameService implements LoadGameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> loadGames() throws AppErrorException {
        return gameRepository.getGames();
    }

    @Override
    public Game loadGame(long gameId) throws AppErrorException, ResourceNotFoundException {
        Game gameModel = gameRepository.getGameById(gameId);
        if (gameModel == null) {
            throw new ResourceNotFoundException(new Exception("Not Found Game with id [" + gameId + "]"));
        }
        return gameModel;
    }
}