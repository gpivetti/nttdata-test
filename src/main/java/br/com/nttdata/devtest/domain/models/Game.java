package br.com.nttdata.devtest.domain.models;

import br.com.nttdata.devtest.domain.models.types.WinnerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "games")
public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "playerName", nullable = false)
    private String playerName;

    @Column(name = "gameDate")
    private String date;

    @Column(name = "playerWins")
    private int playerWins;

    @Column(name = "npcWins")
    private int npcWins;

    @Column(name = "winner", nullable = false)
    @Enumerated(EnumType.STRING)
    private WinnerType winner;

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private List<GameRound> rounds;
}
