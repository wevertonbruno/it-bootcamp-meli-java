public class SocorristaMoto implements VeiculoSocorrista<Motocicleta>{
    @Override
    public void socorrer(Motocicleta veiculo) {
        System.out.println("Socorro motocicleta " + veiculo.getPlaca());
    }
}
