package entities;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemProduto extends Entity{
    private Produto produto;
    private Integer quantidade;

    public ItemProduto(Produto produto, Integer quantidade) {
        super(UUID.randomUUID());
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public BigDecimal getSubTotal(){
        return produto.getPrecoUnitario().multiply(BigDecimal.valueOf(quantidade));
    }

    public String toPrint(){
        return String.format("%d x %s \t %.2f", quantidade, produto.getNome(), getSubTotal().floatValue());
    }

    @Override
    public String toString() {
        return "ItemProduto{" +
                "ID=" + produto +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
