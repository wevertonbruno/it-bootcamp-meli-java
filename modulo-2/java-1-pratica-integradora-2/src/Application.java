import Domain.*;

public class Application {
    public static void main(String[] args) {
        CircuitoPequeno circuitoPequeno = new CircuitoPequeno();
        CircuitoMedio circuitoMedio = new CircuitoMedio();
        CircuitoAvancado circuitoAvancado = new CircuitoAvancado();

        UI ui = new UI(circuitoPequeno, circuitoMedio, circuitoAvancado);

        ui.run();
    }
}
