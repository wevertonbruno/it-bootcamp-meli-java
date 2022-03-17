package entities;

import java.util.Objects;
import java.util.UUID;

public class Cliente extends Entity{
    private String nome;
    private String sobrenome;

    public Cliente(String nome, String sobrenome) {
        super();
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Cliente(UUID ID, String nome, String sobrenome){
        super(ID);
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID='" + getID() + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                '}';
    }
}
