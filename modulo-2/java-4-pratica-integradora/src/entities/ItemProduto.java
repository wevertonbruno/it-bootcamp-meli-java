package entities;

import java.math.BigDecimal;

public class ItemProduto extends Entity{
    private Produto produto;
    private Integer quantidade;

    public ItemProduto(Produto produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public BigDecimal getTotal(){
        return produto.getPrecoUnitario().multiply(BigDecimal.valueOf(quantidade));
    }

    @Override
    public String toString() {
        return "ItemProduto{" +
                "ID=" + getID() +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
