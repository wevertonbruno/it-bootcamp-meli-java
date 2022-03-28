package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "O nome do assunto não pode ficar vazio.")
    @Size(max = 30, message = "O comprimento do nome não pode exceder 30 caracteres.")
    @Pattern(regexp = "^[A-zÀ-ú][A-zÀ-ú ]*", message = "O nome do assunto deve começar com letra maiúscula.")
    String name;

    @NotNull(message = "A nota não pode estar vazia.")
    @Min(value = 0, message = "A nota mínima é 0,0.")
    @Max(value = 10, message = "A nota máxima é 0,0.")
    Double score;
}
