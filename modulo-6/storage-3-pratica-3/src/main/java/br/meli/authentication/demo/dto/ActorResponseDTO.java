package br.meli.authentication.demo.dto;

import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.entities.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;
    private Movie favoriteMovie;

    public FavoriteMovieDTO getFavoriteMovie() {
        if (favoriteMovie == null) return null;

        return new FavoriteMovieDTO(
                favoriteMovie.getId(),
                favoriteMovie.getTitle(),
                favoriteMovie.getAwards(),
                favoriteMovie.getRating(),
                favoriteMovie.getReleaseDate(),
                favoriteMovie.getLength()
        );
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class FavoriteMovieDTO{
        private Long id;
        private String title;
        private Integer awards;
        private Double rating;
        private LocalDate releaseDate;
        private Integer length;
    }

    public static ActorResponseDTO of(Actor actor){
        return new ActorResponseDTO(
                actor.getId(),
                actor.getFirstName(),
                actor.getLastName(),
                actor.getRating(),
                actor.getFavoriteMovie()
        );
    }
}
