package br.com.meli.spring1pratica2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
            palavraTraduzida += codigoMorseMapper.getCharacter(letter);
        }

        return palavraTraduzida;
    }

    public String converterTexto(String texto){
        String[] words = texto.split(" ");
        List<String> palavrasConvertidas = new ArrayList<>();

        for (String word : words) {
            palavrasConvertidas.add(converterPalavra(word));
        }

        return String.join("  ", palavrasConvertidas);
    }

    private String converterPalavra(String palavra){
        char[] letters = normalizarString(palavra).toUpperCase().toCharArray();
        List<String> codes = new ArrayList<>();
        for(Character letter : letters){
            codes.add(codigoMorseMapper.getCode(letter));
        }

        return String.join(" ", codes);
    }

    private String normalizarString(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }

}
