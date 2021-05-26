package br.com.nttdata.devtest.domain.services;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;
import br.com.nttdata.devtest.main.exceptions.ResourceNotFoundException;

import java.util.List;

public interface LoadGameService {
    List<Game> loadGames() throws AppErrorException;
    Game loadGame (long gameId) throws AppErrorException, ResourceNotFoundException;
}
