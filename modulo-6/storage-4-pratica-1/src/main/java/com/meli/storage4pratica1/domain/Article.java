package com.meli.storage4pratica1.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Document(indexName = "blog")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {
        @Id
        private String id;
        private String title;

        @Field(type = FieldType.Nested, includeInParent = true)
        private List<Author> authors;
}
