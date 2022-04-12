package br.meli.authentication.demo.repositories;

import br.meli.authentication.demo.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT DISTINCT am.movie FROM Actor a " +
            "INNER JOIN ActorMovie am ON am.actor.id = a.id " +
            "WHERE a.rating > :rating")
    List<Movie> findByActorsRatingGreaterThan(Double rating);
    List<Movie> findByGenre_Id(Long genreId);
}
