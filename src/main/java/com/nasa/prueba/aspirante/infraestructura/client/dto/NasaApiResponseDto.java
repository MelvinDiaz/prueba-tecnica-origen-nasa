package com.nasa.prueba.aspirante.infraestructura.client.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NasaApiResponseDto {
    private NasaCollectionDto collection;
}
