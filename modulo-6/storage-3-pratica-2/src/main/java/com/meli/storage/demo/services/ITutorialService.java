package com.meli.storage.demo.services;

import com.meli.storage.demo.dto.TutorialDTO;
import com.meli.storage.demo.entities.Status;

import java.time.LocalDate;
import java.util.List;

public interface ITutorialService {
    TutorialDTO create(TutorialDTO tutorial);
    TutorialDTO update(Long ID, TutorialDTO tutorial);
    List<TutorialDTO> findAll();
    List<TutorialDTO> search(String title);
    List<TutorialDTO> searchByStatus(Status status);
    TutorialDTO findById(Long ID);
    void delete(Long ID);
    void deleteAll();

}
