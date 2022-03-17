package br.com.meli.spring1pratica2.controllers;


import br.com.meli.spring1pratica2.controllers.DTO.MorseResponse;
import br.com.meli.spring1pratica2.services.CodigoMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codigo-morse")
public class MorseController {

    private CodigoMorseService codigoMorseService;

    @Autowired
    public MorseController(CodigoMorseService codigoMorseService) {
        this.codigoMorseService = codigoMorseService;
    }

    @GetMapping("/traduzir")
    public ResponseEntity<MorseResponse> traduzir(@RequestParam String codigo) {
        MorseResponse response = new MorseResponse(codigoMorseService.traduzirTexto(codigo));
        return ResponseEntity.ok(response);
    }

    @GetMapping("/converter")
    public ResponseEntity<MorseResponse> converter(@RequestParam String texto){
        MorseResponse response = new MorseResponse(codigoMorseService.converterTexto(texto));
        return ResponseEntity.ok(response);
    }
}
