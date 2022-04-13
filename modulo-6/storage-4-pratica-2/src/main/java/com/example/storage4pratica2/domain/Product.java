package com.example.storage4pratica2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = Indicies.PRODUCT_INDEX)
@Setting(settingPath = "static/es-config.json")
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
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Category {
        private String id;
        @Field(type = FieldType.Keyword)
        private String name;
    }
}
