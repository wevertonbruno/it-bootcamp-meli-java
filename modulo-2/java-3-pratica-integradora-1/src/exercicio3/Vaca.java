package exercicio3;

public class Vaca extends Animal{
    @Override
    public void emitirSom() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        System.out.println("Comendo planta");
    }
}
