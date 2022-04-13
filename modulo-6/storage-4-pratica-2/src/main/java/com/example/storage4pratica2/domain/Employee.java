package com.example.storage4pratica2.domain;

import com.example.storage4pratica2.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "employee")
public class Employee {
    @Id
    private String id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    @Field(type = FieldType.Text)
    private State state;
    private String city;
}
