package br.com.nttdata.devtest.infra.mysql;

import br.com.nttdata.devtest.domain.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MysqlGameJpa extends JpaRepository<Game, Long> {

}
