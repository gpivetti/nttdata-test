package br.com.nttdata.devtest.application;

import br.com.nttdata.devtest.application.helper.GetExceptionMessageHelper;
import br.com.nttdata.devtest.domain.helper.GameRoundHelper;
import br.com.nttdata.devtest.domain.helper.SudokuSelectionsHelper;
import br.com.nttdata.devtest.domain.models.GameRound;
import br.com.nttdata.devtest.domain.models.types.WinnerType;
import br.com.nttdata.devtest.domain.facade.CurrentGameFacade;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/game")
public class SudokuController {
    private static final int ROUND_COUNT = 10;
    private static final String GAME_ATTRIBUTE_NAME = "game";

    @Autowired
    private CurrentGameFacade currentGameFacade;

    private int roundCount = 0;
    private final List<String> choices = SudokuSelectionsHelper.getStringList();

    @GetMapping("")
    public String game(final Model model) {
        try {
            startGameIfItIsNew(model);
            model.addAttribute("roundCount", this.roundCount);
            model.addAttribute("choices", this.choices);
            model.addAttribute(GAME_ATTRIBUTE_NAME, currentGameFacade.getCurrentGame());
        } catch (AppErrorException ex) {
            ex.printStackTrace();
            model.addAttribute("errorMessage", GetExceptionMessageHelper.getErrorMessage(ex.getMessage()));
        }
        return "game";
    }

    @PostMapping("/addRound")
    public RedirectView addRound(RedirectAttributes redirectAttributes,
                                 @RequestParam(value = "choice", required = false, defaultValue = "false")
                                     final String userChoice) {
        try {
            redirectAttributes.addFlashAttribute("gameRound", creteAndReturningGameRoundByUserChoice(userChoice));
        } catch (AppErrorException ex) {
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("errorMessage",
                    GetExceptionMessageHelper.getErrorMessage(ex.getMessage()));
        }
        return new RedirectView("/game", true);
    }

    private void startGameIfItIsNew(Model model) {
        boolean newGame = model.getAttribute("newGame") != null ?
                (Boolean) Objects.requireNonNull(model.getAttribute("newGame")): false;
        if (currentGameFacade.getCurrentGame() == null || newGame) {
            String playerName = model.getAttribute("playerName") != null ?
                    Objects.requireNonNull(model.getAttribute("playerName")).toString() : null;
            this.roundCount = 0;
            currentGameFacade.newCurrentGame(playerName, ROUND_COUNT);
        }
    }

    private GameRound creteAndReturningGameRoundByUserChoice(String userChoice) {
        var gameRound = GameRoundHelper.createGameRound(userChoice);
        if (gameRound.getWinner() != WinnerType.DRAW) {
            this.roundCount += 1;
            currentGameFacade.addRoundOnCurrentGame(gameRound);
        }
        return gameRound;
    }
}
