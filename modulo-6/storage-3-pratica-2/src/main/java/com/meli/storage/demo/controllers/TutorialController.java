package com.meli.storage.demo.controllers;

import com.meli.storage.demo.dto.TutorialDTO;
import com.meli.storage.demo.entities.Status;
import com.meli.storage.demo.services.ITutorialService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/v1/tutorial")
public class TutorialController {

    private final ITutorialService tutorialService;

    public TutorialController(ITutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @GetMapping
    public ResponseEntity<List<TutorialDTO>> findAll(){
        return ResponseEntity.ok(tutorialService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorialDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(tutorialService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        tutorialService.delete(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<?> deleteAll(){
        tutorialService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<TutorialDTO> create(@RequestBody TutorialDTO dto, HttpServletRequest request){
        TutorialDTO joiaDTO = tutorialService.create(dto);
        URI uri = URI.create(request.getRequestURI().concat("/" + joiaDTO.getId()));
        return ResponseEntity.created(uri).body(joiaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TutorialDTO> update(
            @PathVariable Long id,
            @RequestBody TutorialDTO dto
    ){
        TutorialDTO joiaDTO = tutorialService.update(id, dto);
        return ResponseEntity.ok(joiaDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TutorialDTO>> search(
            @RequestParam String title
    ){
        System.out.println(title);
        return ResponseEntity.ok(tutorialService.search(title));
    }

    @GetMapping("/published")
    public ResponseEntity<List<TutorialDTO>> publisheds(){
        return ResponseEntity.ok(tutorialService.searchByStatus(Status.PUBLISHED));
    }
}
