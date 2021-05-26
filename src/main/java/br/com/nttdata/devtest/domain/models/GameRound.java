package br.com.nttdata.devtest.domain.models;

import br.com.nttdata.devtest.domain.models.types.SudokuSelections;
import br.com.nttdata.devtest.domain.models.types.WinnerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gameRounds")
public class GameRound implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "playerChoice", nullable = false)
    @Enumerated(EnumType.STRING)
    private SudokuSelections playerChoice;

    @Column(name = "npcChoice", nullable = false)
    @Enumerated(EnumType.STRING)
    private SudokuSelections npcChoice;

    @Column(name = "winner", nullable = false)
    @Enumerated(EnumType.STRING)
    private WinnerType winner;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)
    private Game game;
}
