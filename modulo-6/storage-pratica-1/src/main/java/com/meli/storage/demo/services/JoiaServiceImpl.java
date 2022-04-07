package com.meli.storage.demo.services;

import com.meli.storage.demo.dto.JoiaDTO;
import com.meli.storage.demo.entities.Joia;
import com.meli.storage.demo.repositories.JoiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JoiaServiceImpl implements JoiaService{
    private final JoiaRepository repository;

    @Override
    public JoiaDTO create(JoiaDTO joiaDTO) {
        Joia joia = new Joia();

        joia.setMaterial(joiaDTO.getMaterial());
        joia.setPeso(joiaDTO.getPeso());
        joia.setQuilates(joiaDTO.getQuilates());

        return JoiaDTO.fromJoia(repository.save(joia));
    }

    @Override
    public JoiaDTO update(UUID ID, JoiaDTO body) {
        Joia joiaUpdated = repository.findById(ID)
                .map(joia -> {
                    joia.setQuilates(body.getQuilates());
                    joia.setMaterial(body.getMaterial());
                    joia.setPeso(body.getPeso());

                    return joia;
                })
                .orElseThrow(() -> new RuntimeException("Joia nao encontrada!"));

        return JoiaDTO.fromJoia(repository.save(joiaUpdated));
    }

    @Override
    public List<JoiaDTO> findAll() {
        return repository.findAll()
                .stream().map(JoiaDTO::fromJoia).collect(Collectors.toList());
    }

    @Override
    public JoiaDTO findById(UUID ID) {
        Joia joia = repository.findById(ID)
                .orElseThrow(() -> new RuntimeException("Joia nao encontrada!"));

        return JoiaDTO.fromJoia(joia);
    }

    @Override
    public void delete(UUID ID) {
        repository.findById(ID)
                .orElseThrow(() -> new RuntimeException("Joia nao encontrada!"));

        repository.deleteById(ID);
    }
}
