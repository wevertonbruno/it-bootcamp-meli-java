package br.meli.authentication.demo.repositories;

import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.entities.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByFavoriteMovieNotNull();
    List<Actor> findByRatingGreaterThan(Double rating);
    @Query("SELECT DISTINCT e FROM ActorEpisode a " +
            "INNER JOIN Episode e ON a.episode.id = e.id " +
            "WHERE a.actor.id = :id")
    List<Episode> findAllEpisodesById(Long id);
}
