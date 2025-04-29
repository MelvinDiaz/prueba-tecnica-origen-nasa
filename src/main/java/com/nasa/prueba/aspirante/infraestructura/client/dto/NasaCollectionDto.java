package com.nasa.prueba.aspirante.infraestructura.client.dto;

import lombok.Data;
import java.util.List;

@Data
public class NasaCollectionDto {
    private String version;
    private String href;
    private List<NasaItemDto> items;
}
