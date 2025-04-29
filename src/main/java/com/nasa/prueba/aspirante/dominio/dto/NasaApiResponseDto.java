package com.nasa.prueba.aspirante.dominio.dto;

import lombok.Data;

import java.util.List;

@Data
public class NasaApiResponseDto {
    private NasaCollectionDto collection;

    @Data
    public static class NasaDataDto {
        private String center;
        private String title;
        private String nasa_id;
    }

    @Data
    public static class NasaItemDto {
        private String href;
        private List<NasaDataDto> data;
    }
}
