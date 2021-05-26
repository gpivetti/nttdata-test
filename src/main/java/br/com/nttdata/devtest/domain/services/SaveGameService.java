package br.com.nttdata.devtest.domain.services;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;

public interface SaveGameService {
    Game insert(Game gameModel) throws AppErrorException;
}
