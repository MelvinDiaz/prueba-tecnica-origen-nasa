package com.nasa.prueba.aspirante.infraestructura.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore fields not defined here
public class NasaDataDto {
    private String center;
    private String title;
    private String nasa_id;
    // Add other fields from the 'data' object if needed, like description, date_created, etc.
}
