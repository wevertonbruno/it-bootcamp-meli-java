package br.com.meli.spring1pratica2.controllers.DTO;

public class ResponseDTO {
    private Integer idade;

    public ResponseDTO(Integer idade) {
        this.idade = idade;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "idade='" + idade + '\'' +
                '}';
    }
}
