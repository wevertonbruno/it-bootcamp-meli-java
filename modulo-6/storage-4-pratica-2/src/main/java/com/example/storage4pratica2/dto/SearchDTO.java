package com.example.storage4pratica2.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class SearchDTO {
    private List<String> fields;
    private String term;
}
