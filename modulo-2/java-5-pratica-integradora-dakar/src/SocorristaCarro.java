public class SocorristaCarro implements VeiculoSocorrista<Carro>{
    @Override
    public void socorrer(Carro veiculo) {
        System.out.println("Socorro carro " + veiculo.getPlaca());
    }
}
