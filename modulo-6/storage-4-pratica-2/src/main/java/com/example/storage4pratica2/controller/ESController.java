package com.example.storage4pratica2.controller;

import com.example.storage4pratica2.service.ElasticsearchIndexService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/elasticsearch")
public class ESController {

    private final ElasticsearchIndexService service;

    public ESController(ElasticsearchIndexService service) {
        this.service = service;
    }

    @PostMapping("/reindex")
    public ResponseEntity<?> reindex(){
        service.createIndexes(true);
        return ResponseEntity.noContent().build();
    }
}
