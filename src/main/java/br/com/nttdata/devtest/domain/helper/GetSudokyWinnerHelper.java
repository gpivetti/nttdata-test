package br.com.nttdata.devtest.domain.helper;

import br.com.nttdata.devtest.domain.models.types.SudokuSelections;
import br.com.nttdata.devtest.domain.models.types.WinnerType;

public class GetSudokyWinnerHelper {

    public static final SudokuSelections STONE_GREATER = SudokuSelections.PAPEL;
    public static final SudokuSelections PAPER_GREATER = SudokuSelections.TESOURA;
    public static final SudokuSelections SCISSOR_GREATER = SudokuSelections.PEDRA;

    public static WinnerType getWinner(SudokuSelections playerChoice, SudokuSelections npcChoice) {
        if (playerChoice == npcChoice) {
            return WinnerType.DRAW;
        } else if (playerChoice == SudokuSelections.PEDRA && npcChoice == STONE_GREATER) {
            return WinnerType.NPC;
        } else if (playerChoice == SudokuSelections.PAPEL && npcChoice == PAPER_GREATER) {
            return WinnerType.NPC;
        } else if (playerChoice == SudokuSelections.TESOURA && npcChoice == SCISSOR_GREATER) {
            return WinnerType.NPC;
        } else {
            return WinnerType.PLAYER;
        }
    }
}
