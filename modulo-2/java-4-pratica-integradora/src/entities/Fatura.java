package entities;

import java.util.ArrayList;
import java.util.List;

public class Fatura extends Entity{
    private Cliente cliente;
    private List<ItemProduto> produtos = new ArrayList<>();

    public Fatura(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fatura(Cliente cliente, List<ItemProduto> produtos) {
        this.cliente = cliente;
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ItemProduto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "ID='" + getID() + '\'' +
                ", cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
