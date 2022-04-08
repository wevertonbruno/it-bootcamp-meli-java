package com.meli.storage.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.storage.demo.entities.TestCase;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestCaseDTO {
    private Long id;
    private String description;
    private Boolean tested;
    private Boolean passed;
    @JsonProperty("number_of_tries")
    private Integer numberOfTries;

    @JsonProperty("last_update")
    private LocalDate lastUpdate;

    public static TestCaseDTO fromTestCase(TestCase test){
        return new TestCaseDTO(
                test.getId(),
                test.getDescription(),
                test.getTested(),
                test.getPassed(),
                test.getNumberOfTries(),
                test.getLastUpdate()
        );
    }
}
