package com.meli.storage.demo.controllers;

import com.meli.storage.demo.dto.JoiaDTO;
import com.meli.storage.demo.services.JoiaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/joia")
public class JoiaController {

    private final JoiaService joiaService;

    public JoiaController(JoiaService joiaService) {
        this.joiaService = joiaService;
    }

    @GetMapping
    public ResponseEntity<List<JoiaDTO>> findAll(){
        return ResponseEntity.ok(joiaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoiaDTO> findById(@PathVariable UUID id){
        return ResponseEntity.ok(joiaService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id){
        joiaService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<JoiaDTO> create(@RequestBody JoiaDTO dto, HttpServletRequest request){
        JoiaDTO joiaDTO = joiaService.create(dto);
        URI uri = URI.create(request.getRequestURI().concat("/" + joiaDTO.getId()));
        return ResponseEntity.created(uri).body(joiaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JoiaDTO> update(
            @PathVariable UUID id,
            @RequestBody JoiaDTO dto
    ){
        JoiaDTO joiaDTO = joiaService.update(id, dto);
        return ResponseEntity.ok(joiaDTO);
    }
}
