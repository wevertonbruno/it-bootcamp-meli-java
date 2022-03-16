public abstract class Veiculo {
    private Float velocidade;
    private Float aceleracao;
    private Float anguloGiro;
    private String placa;
    private Float peso;
    private Integer rodas;

    public Veiculo(Float velocidade, Float aceleracao, Float anguloGiro, String placa, Float peso, Integer rodas) {
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.anguloGiro = anguloGiro;
        this.placa = placa;
        this.peso = peso;
        this.rodas = rodas;
    }

    public String getPlaca() {
        return placa;
    }

    public Float getPerformance(){
        return velocidade * (aceleracao / 2) / (anguloGiro * (peso - rodas * 100));
    }
}
