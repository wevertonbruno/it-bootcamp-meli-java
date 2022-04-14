package com.example.storage4pratica2.domain;

import com.example.storage4pratica2.domain.enums.State;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = Indicies.EMPLOYEE_INDEX, createIndex = false)
public class Employee {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String surname;
    @Field(type = FieldType.Date, name = "birth_date")
    private LocalDate birthDate;
    @Field(type = FieldType.Keyword)
    private State state;
    @Field(type = FieldType.Text)
    private String city;
}
