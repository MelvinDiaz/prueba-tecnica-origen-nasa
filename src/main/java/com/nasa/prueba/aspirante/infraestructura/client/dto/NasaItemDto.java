package com.nasa.prueba.aspirante.infraestructura.client.dto;

import lombok.Data;
import java.util.List;

@Data
public class NasaItemDto {
    private String href;
    private List<NasaDataDto> data;
}
