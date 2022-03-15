package entities;

import java.util.ArrayList;
import java.util.List;

public class Garagem {
    private String ID;
    private List<Veiculo> veiculos = new ArrayList<>();

    public Garagem(String ID) {
        this.ID = ID;
    }

    public Garagem(String ID, List<Veiculo> veiculos) {
        this.ID = ID;
        this.veiculos = veiculos;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public void addVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

}
