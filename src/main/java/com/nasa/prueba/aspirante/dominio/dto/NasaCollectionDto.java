package com.nasa.prueba.aspirante.dominio.dto;

import lombok.Data;
import java.util.List;

@Data
public class NasaCollectionDto {
    private String version;
    private String href;
    private List<NasaApiResponseDto.NasaItemDto> items;
}
