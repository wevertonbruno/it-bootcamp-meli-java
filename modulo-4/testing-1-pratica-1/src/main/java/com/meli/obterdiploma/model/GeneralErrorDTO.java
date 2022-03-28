package com.meli.obterdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

@Data
@AllArgsConstructor
public class GeneralErrorDTO {
    private String type;
    private Instant time;
    private String message;
}
