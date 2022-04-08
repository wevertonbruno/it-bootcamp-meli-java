package com.meli.storage.demo.repositories;

import com.meli.storage.demo.entities.Status;
import com.meli.storage.demo.entities.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByStatus (Status status);
    List<Tutorial> findByTitleContaining(String title);
}
