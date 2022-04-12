package br.meli.authentication.demo.dto;

import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.entities.ActorMovie;
import br.meli.authentication.demo.entities.Genre;
import br.meli.authentication.demo.entities.Movie;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponseDTO {
    private Long id;
    private String title;
    private Integer awards;
    private Double rating;
    private LocalDate releaseDate;
    private Integer length;
    private Set<ActorMovie> actors = new HashSet<>();
    private Genre genre;

    public Set<Actor> getActors() {
        return actors.stream()
                .map(actorMovie -> actorMovie.getActor())
                .collect(Collectors.toSet());
    }

    public static MovieResponseDTO of(Movie movie){
        return new MovieResponseDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getAwards(),
                movie.getRating(),
                movie.getReleaseDate(),
                movie.getLength(),
                movie.getActors(),
                movie.getGenre()
        );
    }
}
