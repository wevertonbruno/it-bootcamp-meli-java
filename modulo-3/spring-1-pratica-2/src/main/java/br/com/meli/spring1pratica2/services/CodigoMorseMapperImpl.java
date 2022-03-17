package br.com.meli.spring1pratica2.services;

import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Map;

@Component
public class CodigoMorseMapperImpl implements CodigoMorseMapper{
    private static Map<String, Character> CODIGO_MAPPER = Map.ofEntries(
            new AbstractMap.SimpleEntry<String, Character>(".-",    'A'),
            new AbstractMap.SimpleEntry<String, Character>("-...",  'B'),
            new AbstractMap.SimpleEntry<String, Character>("-.-.",  'C'),
            new AbstractMap.SimpleEntry<String, Character>("-..",   'D'),
            new AbstractMap.SimpleEntry<String, Character>(".",     'E'),
            new AbstractMap.SimpleEntry<String, Character>("..-.",  'F'),
            new AbstractMap.SimpleEntry<String, Character>("--.",   'G'),
            new AbstractMap.SimpleEntry<String, Character>("....",  'H'),
            new AbstractMap.SimpleEntry<String, Character>("..",    'I'),
            new AbstractMap.SimpleEntry<String, Character>(".---",  'J'),
            new AbstractMap.SimpleEntry<String, Character>("-.-",   'K'),
            new AbstractMap.SimpleEntry<String, Character>(".-..",  'L'),
            new AbstractMap.SimpleEntry<String, Character>("--",    'M'),
            new AbstractMap.SimpleEntry<String, Character>("-.",    'N'),
            new AbstractMap.SimpleEntry<String, Character>("---",   'O'),
            new AbstractMap.SimpleEntry<String, Character>(".--.",  'P'),
            new AbstractMap.SimpleEntry<String, Character>("--.-",  'Q'),
            new AbstractMap.SimpleEntry<String, Character>(".-.",   'R'),
            new AbstractMap.SimpleEntry<String, Character>("...",   'S'),
            new AbstractMap.SimpleEntry<String, Character>("-",     'T'),
            new AbstractMap.SimpleEntry<String, Character>("..-",   'U'),
            new AbstractMap.SimpleEntry<String, Character>("...-",  'V'),
            new AbstractMap.SimpleEntry<String, Character>(".--",   'W'),
            new AbstractMap.SimpleEntry<String, Character>("-..-",  'X'),
            new AbstractMap.SimpleEntry<String, Character>("-.--",  'Y'),
            new AbstractMap.SimpleEntry<String, Character>("--..",  'Z'),
            new AbstractMap.SimpleEntry<String, Character>("·----", '1'),
            new AbstractMap.SimpleEntry<String, Character>("··---", '2'),
            new AbstractMap.SimpleEntry<String, Character>("···--", '3'),
            new AbstractMap.SimpleEntry<String, Character>("····-", '4'),
            new AbstractMap.SimpleEntry<String, Character>("·····", '5'),
            new AbstractMap.SimpleEntry<String, Character>("-····", '6'),
            new AbstractMap.SimpleEntry<String, Character>("--···", '7'),
            new AbstractMap.SimpleEntry<String, Character>("---··", '8'),
            new AbstractMap.SimpleEntry<String, Character>("----·", '9'),
            new AbstractMap.SimpleEntry<String, Character>("-----", '0'),
            new AbstractMap.SimpleEntry<String, Character>("..--..", '?'),
            new AbstractMap.SimpleEntry<String, Character>("-.-.--", '!'),
            new AbstractMap.SimpleEntry<String, Character>(".-.-.-", '.'),
            new AbstractMap.SimpleEntry<String, Character>("--..--", '0')
    );

    public Character get(String key){
        return CODIGO_MAPPER.get(key);
    }
}
