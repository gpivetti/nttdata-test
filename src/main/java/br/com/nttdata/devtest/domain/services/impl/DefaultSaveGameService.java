package br.com.nttdata.devtest.domain.services.impl;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.domain.repository.GameRepository;
import br.com.nttdata.devtest.domain.services.SaveGameService;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;
import br.com.nttdata.devtest.main.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultSaveGameService implements SaveGameService {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public Game insert(Game gameModel) throws AppErrorException {
        if (gameModel == null) {
            throw new AppErrorException(new Exception("Nullable gameModel for saving"));
        }
        return saveGame(gameModel);
    }

    private Game saveGame(Game gameModel) {
        gameModel = gameRepository.save(gameModel);
        if (gameModel == null) {
            throw new AppErrorException(new Exception("Error on save Game: Response is null"));
        }
        return gameModel;
    }

    private void validatingGameRequest(Game gameModel) throws AppErrorException, ResourceNotFoundException {
        if (gameModel == null) {
            throw new AppErrorException(new Exception("Nullable gameModel for saving"));
        }
    }
}