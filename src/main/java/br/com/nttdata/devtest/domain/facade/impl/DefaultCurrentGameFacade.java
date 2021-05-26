package br.com.nttdata.devtest.domain.facade.impl;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.domain.models.GameRound;
import br.com.nttdata.devtest.domain.models.types.WinnerType;
import br.com.nttdata.devtest.domain.facade.CurrentGameFacade;
import br.com.nttdata.devtest.domain.services.SaveGameService;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;
import br.com.nttdata.devtest.main.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultCurrentGameFacade implements CurrentGameFacade {

    @Autowired
    private SaveGameService saveGameService;

    private int rounds = 0;
    private Game gameModel = null;

    @Override
    public Game getCurrentGame() {
        return this.gameModel;
    }

    @Override
    public void newCurrentGame(String playerName, final int rounds) throws AppErrorException {
        if (playerName == null || playerName.trim().equals("")) {
            throw new AppErrorException(new Exception("Invalid Player Name"));
        }
        if (rounds == 0L) {
            throw new AppErrorException(new Exception("Invalid Round Count Game"));
        }
        this.rounds = rounds;
        this.gameModel = Game.builder()
                .playerName(playerName)
                .playerWins(0)
                .npcWins(0)
                .date(DateUtils.getStringCurrentDateTime())
                .build();
    }

    @Override
    public void addRoundOnCurrentGame(GameRound gameRoundModel)  throws AppErrorException {
        if (this.gameModel == null || gameRoundModel == null) {
            throw new AppErrorException(new Exception("Invalid Data for adding Round"));
        }
        insertingNewRoundOnGame(gameRoundModel);
        if (this.gameModel.getRounds().size() >= this.rounds) {
            this.gameModel.setWinner(getWinnerType(this.gameModel.getRounds()));
            saveCurrentGame();
        }
    }

    @Override
    public Game saveCurrentGame() throws AppErrorException {
        if (this.gameModel == null || this.gameModel.getRounds() == null || this.gameModel.getRounds().isEmpty()) {
            throw new AppErrorException(new Exception("Invalid Game for saving: Game was not started"));
        }
        return saveGameService.insert(gameModel);
    }

    private void insertingNewRoundOnGame(GameRound gameRoundModel) {
        try {
            List<GameRound> gameRoundModels = this.gameModel.getRounds();
            if (gameRoundModels == null) {
                gameRoundModels = new ArrayList<>();
            }
            gameRoundModels.add(gameRoundModel);
            this.gameModel.setRounds(gameRoundModels);
            if (gameRoundModel.getWinner() == WinnerType.PLAYER) {
                this.gameModel.setPlayerWins(this.gameModel.getPlayerWins()+1);
            } else {
                this.gameModel.setNpcWins(this.gameModel.getNpcWins()+1);
            }
        } catch (Exception ex) {
            throw new AppErrorException(ex);
        }
    }

    private WinnerType getWinnerType(List<GameRound> gameRoundModels) {
        int playerWinner = (int) gameRoundModels.stream()
                .filter(round -> round.getWinner() == WinnerType.PLAYER).count();
        int npcWinner = (int) gameRoundModels.stream()
                .filter(round -> round.getWinner() == WinnerType.NPC).count();
        if (playerWinner == npcWinner) {
            return WinnerType.DRAW;
        } else if (playerWinner > npcWinner) {
            return WinnerType.PLAYER;
        } else {
            return WinnerType.NPC;
        }
    }
}