package com.meli.storage.demo.entities;


import com.meli.storage.demo.dto.JoiaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Joia {
    @Id
    @GeneratedValue
    private UUID id;
    private String material;
    private Double peso;
    private Integer quilates;
}
