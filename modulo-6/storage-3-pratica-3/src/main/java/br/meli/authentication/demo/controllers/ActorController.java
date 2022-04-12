package br.meli.authentication.demo.controllers;

import br.meli.authentication.demo.dto.ActorResponseDTO;
import br.meli.authentication.demo.entities.Actor;
import br.meli.authentication.demo.entities.Episode;
import br.meli.authentication.demo.services.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actors")
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping
    public ResponseEntity<ActorResponseDTO> create(@RequestBody Actor actorDto){
        ActorResponseDTO newActor = actorService.create(actorDto);
        return ResponseEntity.ok(newActor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ActorResponseDTO> update(@PathVariable Long id, @RequestBody Actor actorUpdateDto){
        ActorResponseDTO updatedActor = actorService.update(id, actorUpdateDto);
        return ResponseEntity.ok(updatedActor);
    }

    @GetMapping
    public ResponseEntity<List<ActorResponseDTO>> findAll(){
        List<ActorResponseDTO> actors = actorService.findAll();
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ActorResponseDTO>> search(@RequestParam(required = false, name = "has_favorites") String hasFavorites){
        List<ActorResponseDTO> actors = actorService.findAll();
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id){
        Actor actor = actorService.findById(id);
        return ResponseEntity.ok(actor);
    }

    @GetMapping("/{id}/episodes")
    public ResponseEntity<List<Episode>> findAllEpisodesById(@PathVariable Long id){
        List<Episode> episodes = actorService.findAllEpisodesById(id);
        return ResponseEntity.ok(episodes);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> delete(@PathVariable Long id){
        actorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
