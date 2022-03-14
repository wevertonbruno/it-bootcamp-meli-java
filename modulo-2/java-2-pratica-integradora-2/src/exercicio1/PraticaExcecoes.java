package exercicio1;

public class PraticaExcecoes {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;

        try {
            int razao = b/a;
        }catch(ArithmeticException e) {
            throw new IllegalArgumentException("Nao pode ser dividido por zero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
