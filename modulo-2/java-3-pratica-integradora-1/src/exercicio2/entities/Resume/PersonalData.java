package exercicio2.entities.Resume;

public class PersonalData {
    private String nome;
    private String email;
    private String formacao;

    public PersonalData(String nome, String email, String formacao) {
        this.nome = nome;
        this.email = email;
        this.formacao = formacao;
    }

    @Override
    public String toString() {
        return "PersonalData{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", formacao='" + formacao + '\'' +
                '}';
    }
}
