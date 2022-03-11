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
        return "Pessoa{" +
                "ID='" + ID + '\'' +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
