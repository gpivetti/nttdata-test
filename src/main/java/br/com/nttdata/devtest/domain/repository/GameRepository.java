package br.com.nttdata.devtest.domain.repository;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;

import java.util.List;

public interface GameRepository {
    List<Game> getGames() throws AppErrorException;
    Game getGameById(long gameId) throws AppErrorException;
    Game save(Game game) throws AppErrorException;
    void delete(long gameId) throws AppErrorException;
}
