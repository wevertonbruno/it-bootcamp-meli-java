public class Pessoa {
    private String ID;
    private String nome;
    private Integer idade;
    private Float peso;
    private Float altura;

    public Pessoa(){}

    public Pessoa(String ID, String nome, Integer idade){
        this.ID = ID;
        this.idade = idade;
        this.nome = nome;
    }

    public Pessoa(String ID, String nome, Integer idade, Float peso, Float altura) {
        this.ID = ID;
        this.nome = nome;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        float imc = this.peso/(this.altura*this.altura);
        if(imc < 20){ return -1; }
        if(imc >= 20 && imc <= 25){ return 0; }
        return 1;
    }

    public boolean ehMaiorIdade(){
        if(idade >= 18) return true;
        return false;
    }

    @Override
    public String toString() {
        int imc = calcularIMC();
        String imcMsg;

        if(imc == -1){ imcMsg = "Abaixo do peso"; }
        else if(imc == 0){ imcMsg = "Peso saudavel"; }
        else{ imcMsg = "Sobrepeso"; }

        return  String.format("Nome: %s\n", nome) +
                String.format("Idade: %d (%s)\n", idade, ehMaiorIdade() ? "Maior de idade" : "Menor de idade") +
                String.format("Peso: %.2fkg\n", peso) +
                String.format("Altura: %.2fm\n", altura) +
                String.format("ID: %s\n", ID) +
                String.format("IMC: %s\n", imcMsg);
    }
}
