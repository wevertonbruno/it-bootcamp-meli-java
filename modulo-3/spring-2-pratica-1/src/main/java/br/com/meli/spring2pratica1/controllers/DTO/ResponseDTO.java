package br.com.meli.spring2pratica1.controllers.DTO;

import java.io.Serializable;

public class ResponseDTO implements Serializable {
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
