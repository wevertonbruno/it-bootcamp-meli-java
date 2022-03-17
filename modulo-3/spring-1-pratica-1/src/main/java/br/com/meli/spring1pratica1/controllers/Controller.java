package br.com.meli.spring1pratica1.controllers;

import br.com.meli.spring1pratica1.utils.NumeroRomano;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/numero-romano")
public class Controller {

    @GetMapping("/{numero}")
    public ResponseEntity<String> converterNumeroRomano(@PathVariable Integer numero){
        return ResponseEntity.badRequest().body(NumeroRomano.converter(numero));
    }
}
