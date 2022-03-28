package com.meli.obterdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "O nome do aluno não pode ficar vazio.")
    @Size(max = 50, message = "O comprimento do nome não pode exceder 50 caracteres.")
    @Pattern(regexp = "^[A-zÀ-ú][A-zÀ-ú ]*", message = "O nome do aluno deve começar com letra maiúscula.")
    String studentName;

    @Valid
    @NotNull(message = "A lista não pode estar vazia.")
    @NotEmpty(message = "A lista não pode estar vazia.")
    List<SubjectDTO> subjects;

    String message;
    Double averageScore;
}
