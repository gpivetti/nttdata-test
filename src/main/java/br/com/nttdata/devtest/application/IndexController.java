package br.com.nttdata.devtest.application;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.domain.services.LoadGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController<request> {
    private static final String GAME_PAGE = "/game";
    private static final String GAME_ATTRIBUTE_NAME = "games";

    @Autowired
    private LoadGameService loadGameService;

    @GetMapping("")
    public String index(Model model, HttpServletRequest request) {
        List<Game> gameModels = loadGameService.loadGames();
        model.addAttribute(GAME_ATTRIBUTE_NAME, gameModels);
        return "index";
    }

    @PostMapping("/newGame")
    public RedirectView game(final RedirectAttributes redirectAttributes,
                             @RequestParam(value = "player", required = false, defaultValue = "false")
                             final String player)
    {
        redirectAttributes.addFlashAttribute("playerName", player);
        redirectAttributes.addFlashAttribute("newGame", true);
        return new RedirectView(GAME_PAGE, false);
    }
}
