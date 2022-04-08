package com.meli.storage.demo.repositories;

import com.meli.storage.demo.entities.Joia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JoiaRepository extends JpaRepository<Joia, UUID> {
}
