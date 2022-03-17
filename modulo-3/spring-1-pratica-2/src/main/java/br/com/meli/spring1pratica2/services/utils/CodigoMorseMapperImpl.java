package br.com.meli.spring1pratica2.services.utils;

import br.com.meli.spring1pratica2.services.CodigoMorseMapper;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CodigoMorseMapperImpl implements CodigoMorseMapper {
    private static Map<String, Character> CODIGO_MAPPER = Map.ofEntries(
            Map.entry(".-",    'A'),
            Map.entry("-...",  'B'),
            Map.entry("-.-.",  'C'),
            Map.entry("-..",   'D'),
            Map.entry(".",     'E'),
            Map.entry("..-.",  'F'),
            Map.entry("--.",   'G'),
            Map.entry("....",  'H'),
            Map.entry("..",    'I'),
            Map.entry(".---",  'J'),
            Map.entry("-.-",   'K'),
            Map.entry(".-..",  'L'),
            Map.entry("--",    'M'),
            Map.entry("-.",    'N'),
            Map.entry("---",   'O'),
            Map.entry(".--.",  'P'),
            Map.entry("--.-",  'Q'),
            Map.entry(".-.",   'R'),
            Map.entry("...",   'S'),
            Map.entry("-",     'T'),
            Map.entry("..-",   'U'),
            Map.entry("...-",  'V'),
            Map.entry(".--",   'W'),
            Map.entry("-..-",  'X'),
            Map.entry("-.--",  'Y'),
            Map.entry("--..",  'Z'),
            Map.entry("·----", '1'),
            Map.entry("··---", '2'),
            Map.entry("···--", '3'),
            Map.entry("····-", '4'),
            Map.entry("·····", '5'),
            Map.entry("-····", '6'),
            Map.entry("--···", '7'),
            Map.entry("---··", '8'),
            Map.entry("----·", '9'),
            Map.entry("-----", '0'),
            Map.entry("..--..", '?'),
            Map.entry("-.-.--", '!'),
            Map.entry(".-.-.-", '.'),
            Map.entry("--..--", ',')
    );

    private static Map<Character, String> CHARACTER_MAPPER =
            CODIGO_MAPPER.entrySet().stream()
                    .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public Character getCharacter(String key){
        return CODIGO_MAPPER.get(key);
    }

    @Override
    public String getCode(Character character) {
        return CHARACTER_MAPPER.get(character);
    }
}
