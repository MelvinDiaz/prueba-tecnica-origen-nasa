package com.nasa.prueba.aspirante.infraestructura.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaCollectionDto {
    private String version;
    private String href;
    private List<NasaItemDto> items;
    // Add other fields from the 'collection' object if needed, like 'metadata', 'links'
}
