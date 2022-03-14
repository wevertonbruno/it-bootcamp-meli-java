package exercicio2;

import java.util.Arrays;

public class Perecivel extends Produto{
    private int diasParaVencer;

    public Perecivel(String nome, Double preco, int diasParaVencer) {
        super(nome, preco);
        this.diasParaVencer = diasParaVencer;
    }

    public int getDiasParaVencer() {
        return diasParaVencer;
    }

    public void setDiasParaVencer(int diasParaVencer) {
        this.diasParaVencer = diasParaVencer;
    }

    @Override
    public Double calcular(int quantidadeProdutos) {
        Double valor = super.calcular(quantidadeProdutos);

        // Reducao de precos com base nos dias de vencimento
        // 3 dias => 4 vezes; 2 dias => 3 vezes; 1 dia => 2 vezes (50%);
        if(Arrays.asList(1,2,3).contains(diasParaVencer)){
            return valor / (5.0 - diasParaVencer);
        }

        return valor;
    }

    @Override
    public String toString() {
        return "Perecivel{" +
                "diasParaVencer=" + diasParaVencer +
                '}';
    }
}
