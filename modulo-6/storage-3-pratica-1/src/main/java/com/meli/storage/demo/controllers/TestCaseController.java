package com.meli.storage.demo.controllers;

import com.meli.storage.demo.dto.TestCaseDTO;
import com.meli.storage.demo.services.ITestCaseService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/testcases")
public class TestCaseController {

    private final ITestCaseService testCaseService;

    public TestCaseController(ITestCaseService testCaseService) {
        this.testCaseService = testCaseService;
    }

    @GetMapping
    public ResponseEntity<List<TestCaseDTO>> findAll(){
        return ResponseEntity.ok(testCaseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        testCaseService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<TestCaseDTO> create(@RequestBody TestCaseDTO dto, HttpServletRequest request){
        TestCaseDTO joiaDTO = testCaseService.create(dto);
        URI uri = URI.create(request.getRequestURI().concat("/" + joiaDTO.getId()));
        return ResponseEntity.created(uri).body(joiaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> update(
            @PathVariable Long id,
            @RequestBody TestCaseDTO dto
    ){
        TestCaseDTO joiaDTO = testCaseService.update(id, dto);
        return ResponseEntity.ok(joiaDTO);
    }

    @GetMapping("/search")
    public ResponseEntity<List<TestCaseDTO>> search(
            @RequestParam(name = "last_update")
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate lastUpdate
    ){
        return ResponseEntity.ok(testCaseService.search(lastUpdate));
    }
}
