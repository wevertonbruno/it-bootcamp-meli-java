package com.meli.storage.demo.services;

import com.meli.storage.demo.dto.JoiaDTO;

import java.util.List;
import java.util.UUID;

public interface JoiaService {
    JoiaDTO create(JoiaDTO joiaDTO);
    JoiaDTO update(UUID ID, JoiaDTO body);
    List<JoiaDTO> findAll();
    JoiaDTO findById(UUID ID);
    void delete(UUID ID);
}
