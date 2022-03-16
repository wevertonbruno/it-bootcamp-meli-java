package entities;

import java.math.BigDecimal;

public class Produto extends Entity{
    private String nome;
    private BigDecimal precoUnitario;

    public Produto(String nome, BigDecimal precoUnitario) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "ID='" + getID() + '\'' +
                ", nome='" + nome + '\'' +
                ", precoUnitario=" + precoUnitario +
                '}';
    }
}
