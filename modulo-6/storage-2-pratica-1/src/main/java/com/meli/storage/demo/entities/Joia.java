package com.meli.storage.demo.entities;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Builder
public class Joia {
    @Id
    @GeneratedValue
    private UUID id;
    @Enumerated(EnumType.STRING)
    private Material material;
    private Double peso;
    private Integer quilates;
}
