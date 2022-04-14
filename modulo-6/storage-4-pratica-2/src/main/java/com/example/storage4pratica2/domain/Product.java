package com.example.storage4pratica2.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = Indicies.PRODUCT_INDEX, createIndex = false)
public class Product {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Double)
    private Double price;
    @Field(type = FieldType.Keyword)
    private String storage;
    @Field(type = FieldType.Object)
    private Category category;

    @Data
    public static class Category {
        @Field(type = FieldType.Text)
        private String name;
    }
}
