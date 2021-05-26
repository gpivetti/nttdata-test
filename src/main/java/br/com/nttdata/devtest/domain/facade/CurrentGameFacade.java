package br.com.nttdata.devtest.domain.facade;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.domain.models.GameRound;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;

public interface CurrentGameFacade {
    Game getCurrentGame();
    void newCurrentGame(String playerName, final int rounds) throws AppErrorException;
    void addRoundOnCurrentGame(GameRound gameRound) throws AppErrorException;
    Game saveCurrentGame() throws AppErrorException;
}
