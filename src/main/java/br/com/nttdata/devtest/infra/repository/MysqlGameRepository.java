package br.com.nttdata.devtest.infra.repository;

import br.com.nttdata.devtest.domain.models.Game;
import br.com.nttdata.devtest.domain.models.GameRound;
import br.com.nttdata.devtest.domain.repository.GameRepository;
import br.com.nttdata.devtest.infra.mysql.MysqlGameJpa;
import br.com.nttdata.devtest.infra.mysql.MysqlGameRoundJpa;
import br.com.nttdata.devtest.main.exceptions.AppErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MysqlGameRepository implements GameRepository {

    @Autowired
    private MysqlGameJpa mysqlGameJpa;

    @Autowired
    private MysqlGameRoundJpa mysqlGameRoundJpa;

    @Override
    public List<Game> getGames() throws AppErrorException {
        try {
            return (List<Game>) mysqlGameJpa.findAll();
        } catch (Exception ex) {
            throw new AppErrorException(ex);
        }
    }

    @Override
    public Game getGameById(long GameId) throws AppErrorException {
        try {
            Optional<Game> Game = mysqlGameJpa.findById(GameId);
            return Game.orElse(null);
        } catch (Exception ex) {
            throw new AppErrorException(ex);
        }
    }

    @Override
    public Game save(Game gameModel) throws AppErrorException {
        if (gameModel == null) {
            throw new AppErrorException(new Exception("Nullable Game for save"));
        }
        try {
            List<GameRound> gameRoundModels = gameModel.getRounds();
            gameModel.setRounds(null);
            gameModel = mysqlGameJpa.save(gameModel);
            gameModel.setRounds(insertGameRounds(gameModel, gameRoundModels));
            return gameModel;
        } catch (Exception ex) {
            throw new AppErrorException(ex);
        }
    }

    private List<GameRound> insertGameRounds(final Game gameModel, List<GameRound> gameRoundModels) {
        return gameRoundModels.stream().map(gameRound -> {
            gameRound.setGame(gameModel);
            return mysqlGameRoundJpa.save(gameRound);
        }).collect(Collectors.toList());
    }

    @Override
    public void delete(long GameId) throws AppErrorException {
        if (GameId == 0L) {
            throw new AppErrorException(new Exception("Invalid GameId for removing"));
        }
        try {
            mysqlGameJpa.deleteById(GameId);
        } catch (Exception ex) {
            throw new AppErrorException(ex);
        }
    }
}
