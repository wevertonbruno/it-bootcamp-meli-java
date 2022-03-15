import entities.Garagem;
import entities.Veiculo;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Garagem garagem = new Garagem("garagem-1");

        garagem.setVeiculos(Arrays.asList(
                new Veiculo("Ford",     "Fiesta", 1000),
                new Veiculo("Ford",     "Focus", 1200),
                new Veiculo("Ford",     "Explorer", 2500),
                new Veiculo("Fiat",     "Uno", 500),
                new Veiculo("Fiat",     "Cronos", 1000),
                new Veiculo("Fiat",     "Torino", 1250),
                new Veiculo("Chevrolet","Aveo", 1250),
                new Veiculo("Chevrolet","Spin", 2500),
                new Veiculo("Toyota",   "Corola", 1200),
                new Veiculo("Toyota",   "Fortuner", 3000),
                new Veiculo("Renault",  "Logan", 950)
        ));

        System.out.println("\n------ VEICULOS ORDENADOS POR PRECO ---------\n");
        garagem.getVeiculos().stream()
                .sorted((v1, v2) -> v1.getPreco().compareTo(v2.getPreco()))
                .forEach(System.out::println);

        System.out.println("\n------ VEICULOS ORDENADOS POR MARCA ---------\n");
        garagem.getVeiculos()
                .stream()
                .sorted((v1, v2) -> v1.getMarca().compareTo(v2.getMarca()))
                .forEach(System.out::println);

        System.out.println("\n------ VEICULOS COM PRECO MENOR QUE 1000 ---------\n");
        garagem.getVeiculos().stream()
                .filter(veiculo -> veiculo.getPreco() < 1000)
                .forEach(System.out::println);

        System.out.println("\n------ VEICULOS COM PRECO MAIOR OU IGUAL A 1000 ---------\n");
        garagem.getVeiculos().stream()
                .filter(veiculo -> veiculo.getPreco() >= 1000)
                .forEach(System.out::println);

        System.out.println("\n------ MEDIA DE PRECOS DA LISTA DE VEICULOS ---------\n");
        Double media = garagem.getVeiculos().stream().mapToInt(veiculo -> veiculo.getPreco()).summaryStatistics().getAverage();
        System.out.println(String.format("A media eh: %.2f", media));
    }
}
