package exercicio3;

public class Gato extends Animal{
    @Override
    public void emitirSom() {
        System.out.println("miau");
    }

    @Override
    public void comer() {
        System.out.println("Comendo carne");
    }
}
