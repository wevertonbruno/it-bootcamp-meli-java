package com.meli.storage.demo.services;

import com.meli.storage.demo.dto.TutorialDTO;
import com.meli.storage.demo.entities.Status;
import com.meli.storage.demo.entities.Tutorial;
import com.meli.storage.demo.repositories.TutorialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TutorialService implements ITutorialService {
    private final TutorialRepository repository;

    @Override
    public TutorialDTO create(TutorialDTO t) {
        Tutorial tutorial = new Tutorial();
        tutorial.setDescription(t.getDescription());
        tutorial.setStatus(t.getStatus());
        tutorial.setTitle(t.getTitle());

        return TutorialDTO.fromTutorial(repository.save(tutorial));
    }

    @Override
    public TutorialDTO update(Long ID, TutorialDTO t) {
        Tutorial tutorialUpdate = repository.findById(ID)
                .map(tutorial -> {
                    tutorial.setDescription(t.getDescription());
                    tutorial.setStatus(t.getStatus());
                    tutorial.setTitle(t.getTitle());

                    return tutorial;
                })
                .orElseThrow(() -> new RuntimeException("Tutorial nao encontrado!"));

        return TutorialDTO.fromTutorial(repository.save(tutorialUpdate));
    }

    @Override
    public List<TutorialDTO> findAll() {
        return repository.findAll()
                .stream().map(TutorialDTO::fromTutorial).collect(Collectors.toList());
    }

    @Override
    public List<TutorialDTO> search(String title) {
        return repository.findByTitleContaining(title).stream().map(TutorialDTO::fromTutorial).collect(Collectors.toList());
    }

    @Override
    public List<TutorialDTO> searchByStatus(Status status) {
        return repository.findByStatus(status).stream().map(TutorialDTO::fromTutorial).collect(Collectors.toList());
    }

    @Override
    public TutorialDTO findById(Long ID) {
        Tutorial tutorial = repository.findById(ID)
                .orElseThrow(() -> new RuntimeException("Tutorial nao encontrado!"));

        return TutorialDTO.fromTutorial(tutorial);
    }

    @Override
    public void delete(Long ID) {
        repository.findById(ID)
                .orElseThrow(() -> new RuntimeException("Tutorial nao encontrado!"));

        repository.deleteById(ID);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
