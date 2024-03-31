package com.udea.edu.co.directorio.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class EmprendimientoDto {

    private String name;

    //@Column(length = 1000)
   // private List<String> images;

    private String description;

    private Long id;
}
