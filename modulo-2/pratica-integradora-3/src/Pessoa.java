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
}
