package entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Fatura extends Entity{
    private Cliente cliente;
    private List<ItemProduto> items = new ArrayList<>();

    public Fatura(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fatura(Cliente cliente, List<ItemProduto> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public Fatura(UUID ID, Cliente cliente, List<ItemProduto> items){
        super(ID);
        this.cliente = cliente;
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemProduto> getItems() {
        return items;
    }

    public void setItems(List<ItemProduto> items) {
        this.items = items;
    }

    public BigDecimal getTotal(){
        BigDecimal total = BigDecimal.ZERO;

        for (ItemProduto item :
                items) {
            total = total.add(item.getSubTotal());
        }

        return total;
    }

    public String toPrint(){
        return "Cliente: " + getCliente().getNome() + " " + getCliente().getSobrenome() + "\n" +
        getItems().stream().map(item -> item.toPrint()).collect(Collectors.joining("\n")) +
        "\n--------------------------\n" +
        String.format("Total: \t\t %.2f", getTotal().floatValue());
    }

    @Override
    public String toString() {
        return "Fatura{" +
                "ID='" + getID() + '\'' +
                ", cliente=" + cliente +
                ", items=" + items +
                '}';
    }
}
