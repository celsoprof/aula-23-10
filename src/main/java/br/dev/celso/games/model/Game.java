package br.dev.celso.games.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "tb_games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Game {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "game_id")
    private Long gameId;

    private String title;
    private Double value;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private String studio;

}
