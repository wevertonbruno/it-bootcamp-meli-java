package com.meli.storage.demo.dto;

import com.meli.storage.demo.entities.Joia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JoiaDTO {
    private UUID id;
    private String material;
    private Double peso;
    private Integer quilates;

    public static JoiaDTO fromJoia(Joia joia){
        return new JoiaDTO(
                joia.getId(),
                joia.getMaterial(),
                joia.getPeso(),
                joia.getQuilates()
        );
    }
}
