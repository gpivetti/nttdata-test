package br.com.nttdata.devtest.domain.helper;

import br.com.nttdata.devtest.domain.models.GameRound;
import br.com.nttdata.devtest.domain.models.types.SudokuSelections;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;

public class GameRoundHelper {
    public static GameRound createGameRound(String userChoice) throws AppErrorException {
        var playerChoice = getPlayerChoiceByUserChoice(userChoice);
        var npcChoice = SudokuSelectionsHelper.getRandomChoice();
        return GameRound.builder()
                .playerChoice(playerChoice)
                .npcChoice(npcChoice)
                .winner(GetSudokyWinnerHelper.getWinner(playerChoice, npcChoice))
                .build();
    }

    private static SudokuSelections getPlayerChoiceByUserChoice(String userChoice) throws AppErrorException {
        if (userChoice == null || userChoice.trim().equals("")) {
            throw new AppErrorException(new Exception("Invalid User Choice"));
        }
        try {
            return SudokuSelections.valueOf(userChoice);
        } catch (Exception ex) {
            throw new AppErrorException(ex);
        }
    }
}
