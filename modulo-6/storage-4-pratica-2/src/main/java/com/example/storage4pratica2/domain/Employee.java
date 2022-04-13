package com.example.storage4pratica2.domain;

import com.example.storage4pratica2.domain.enums.State;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = Indicies.EMPLOYEE_INDEX)
@Setting(settingPath = "static/es-config.json")
public class Employee {
    @Id
    private String id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Text)
    private String surname;
    @Field(type = FieldType.Date)
    private LocalDate birthDate;
    @Field(type = FieldType.Keyword)
    private State state;
    @Field(type = FieldType.Text)
    private String city;
}
