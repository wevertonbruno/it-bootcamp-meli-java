package br.com.meli.spring1pratica2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CodigoMorseService {
    private CodigoMorseMapper codigoMorseMapper;

    @Autowired
    public CodigoMorseService(CodigoMorseMapper codigoMorseMapper) {
        this.codigoMorseMapper = codigoMorseMapper;
    }

    public String traduzirTexto(String codigo){
        String[] words = codigo.split("  ");
        List<String> palavrasTraduzidas = new ArrayList<>();

        for(String word : words){
            palavrasTraduzidas.add(traduzirPalavra(word));
        }

        return String.join(" ", palavrasTraduzidas);
    }

    private String traduzirPalavra(String palavra){
        String palavraTraduzida = "";
        for(String letter : palavra.split(" ")){
            palavraTraduzida += codigoMorseMapper.get(letter);
        }

        return palavraTraduzida;
    }
}
