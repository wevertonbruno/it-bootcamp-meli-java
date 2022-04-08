package com.meli.storage.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.storage.demo.entities.Status;
import com.meli.storage.demo.entities.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TutorialDTO {
    private Long id;
    private String title;
    private String description;
    private Status status;

    public static TutorialDTO fromTutorial(Tutorial t){
        return new TutorialDTO(
                t.getId(),
                t.getTitle(),
                t.getDescription(),
                t.getStatus()
        );
    }
}
