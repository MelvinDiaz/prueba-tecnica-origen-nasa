package com.nasa.prueba.aspirante.dominio.dto;

import java.time.LocalDateTime;

public record PruebaDto(
        String href,
        String title,
        String nasaId,
        String center,

        LocalDateTime dateTimeCreated
){}
