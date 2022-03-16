import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Corrida {
    private String nome;
    private Float distancia;
    private Integer valorPremio;
    private Integer numeroVeiculosPermitidos;
    private List<Veiculo> veiculos;

    VeiculoSocorrista<Carro> socorristaCarro ;
    VeiculoSocorrista<Motocicleta> socorristaMoto;

    public Corrida(String nome, Float distancia, Integer valorPremio, Integer numeroVeiculosPermitidos) {
        this.nome = nome;
        this.distancia = distancia;
        this.valorPremio = valorPremio;
        this.numeroVeiculosPermitidos = numeroVeiculosPermitidos;

        this.veiculos = new ArrayList<>();
        this.socorristaMoto = new SocorristaMoto();
        this.socorristaCarro = new SocorristaCarro();
    }

    public void addCarro(Float velocidade, Float aceleracao, Float anguloGiro, String placa){
        veiculos.add(new Carro(velocidade, aceleracao, anguloGiro, placa));
    }

    public void addMoto(Float velocidade, Float aceleracao, Float anguloGiro, String placa){
        veiculos.add(new Motocicleta(velocidade, aceleracao, anguloGiro, placa));
    }

    public void deleteVeiculo(Veiculo veiculo){
        veiculos.remove(veiculo);
    }

    public void deleteVeiculoComPlaca(String placa){
        Iterator<Veiculo> veiculosIterator = veiculos.iterator();
        while(veiculosIterator.hasNext()){
            if(veiculosIterator.next().getPlaca().equals(placa)){
                veiculosIterator.remove();
                break;
            }
        }
    }

    public Veiculo getVencedor(){
        return veiculos.stream()
                .max((veiculo1, veiculo2) -> veiculo1.getPerformance().compareTo(veiculo2.getPerformance()))
                .get();
    }

    public void socorrerCarro(String placa){
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Carro && veiculo.getPlaca().equals(placa)) {
                socorristaCarro.socorrer((Carro) veiculo);
            }
        }
    }

    public void socorrerMoto(String placa){
        for (Veiculo veiculo : veiculos) {
            if (veiculo instanceof Motocicleta && veiculo.getPlaca().equals(placa)) {
                socorristaMoto.socorrer((Motocicleta) veiculo);
            }
        }
    }
}
