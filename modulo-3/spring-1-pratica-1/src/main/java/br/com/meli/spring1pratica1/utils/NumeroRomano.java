package br.com.meli.spring1pratica1.utils;

public class NumeroRomano {
    private static Integer[] NUMEROS_ROMANOS = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] SIMBOLOS_ROMANOS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String converter(Integer numero) {
        String convertido = "";
        Integer POSICAO = 0;
        while(numero > 0){
            if (numero < NUMEROS_ROMANOS[POSICAO]){
                POSICAO++;
                continue;
            }
            convertido += SIMBOLOS_ROMANOS[POSICAO];
            numero -= NUMEROS_ROMANOS[POSICAO];
        }

        return convertido;
    }
}
