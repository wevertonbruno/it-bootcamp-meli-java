package exercicio3;

import java.util.Arrays;

public class Main {
    public static void comer(Animal animal){ animal.comer(); }
    public static void main(String[] args) {
        Animal gato = new Gato();
        Animal cachorro = new Cachorro();
        Animal vaca = new Vaca();

        gato.emitirSom();
        cachorro.emitirSom();
        vaca.emitirSom();

        comer(gato);
        comer(cachorro);
        comer(vaca);
    }
}
