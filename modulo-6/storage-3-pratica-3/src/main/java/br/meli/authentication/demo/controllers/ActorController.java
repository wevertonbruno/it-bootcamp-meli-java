package br.meli.authentication.demo.controllers;

import br.meli.authentication.demo.entities.Actor;
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
    public ResponseEntity<Actor> create(@RequestBody Actor actorDto){
        Actor newActor = actorService.create(actorDto);
        return ResponseEntity.ok(newActor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Actor> update(@PathVariable Long id, @RequestBody Actor actorUpdateDto){
        Actor updatedActor = actorService.update(id, actorUpdateDto);
        return ResponseEntity.ok(updatedActor);
    }

    @GetMapping
    public ResponseEntity<List<Actor>> findAll(){
        List<Actor> actors = actorService.findAll();
        return ResponseEntity.ok(actors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> findById(@PathVariable Long id){
        Actor actor = actorService.findById(id);
        return ResponseEntity.ok(actor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Actor> delete(@PathVariable Long id){
        actorService.delete(id);
        return ResponseEntity.ok().build();
    }
}
