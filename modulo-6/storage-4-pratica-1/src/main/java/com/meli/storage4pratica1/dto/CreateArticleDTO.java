package com.meli.storage4pratica1.dto;

import com.meli.storage4pratica1.domain.Author;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CreateArticleDTO {
    private String title;
    private List<Author> authors;
}
