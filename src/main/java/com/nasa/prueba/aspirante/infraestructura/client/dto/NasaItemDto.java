package com.nasa.prueba.aspirante.infraestructura.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaItemDto {
    private String href;
    private List<NasaDataDto> data;
    // Add other fields from the 'item' object if needed, like 'links'
}
