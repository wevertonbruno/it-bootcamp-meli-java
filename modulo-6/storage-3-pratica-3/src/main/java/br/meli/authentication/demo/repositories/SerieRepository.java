package br.meli.authentication.demo.repositories;

import br.meli.authentication.demo.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {
    @Query("SELECT s FROM Serie s WHERE (SELECT COUNT(x) as temporadas FROM Season x WHERE x.serie.id = s.id) > :temporadas")
    List<Serie> findBySeasonsCountGreaterThan(Long temporadas);
}
