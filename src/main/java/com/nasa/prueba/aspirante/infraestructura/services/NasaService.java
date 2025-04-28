package com.nasa.prueba.aspirante.infraestructura.services;

import com.nasa.prueba.aspirante.dominio.dto.PruebaDto;
import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class NasaService {

    private PruebaInterfaz pruebaInterfaz;

    @Transactional(rollbackOn = Exception.class)
    public void guardarPrueba(PruebaDto pruebaDto) {
        System.out.println("Guardando prueba: " + pruebaDto);
        PruebaEntity pruebaEntity = new PruebaEntity();
        pruebaEntity.setHref(pruebaDto.href());
        pruebaEntity.setTitle(pruebaDto.title());
        pruebaEntity.setNasaId(pruebaDto.nasaId());
        pruebaEntity.setCenter(pruebaDto.center());
        pruebaEntity.setDateTimeCreation(pruebaDto.dateTimeCreated());
        pruebaInterfaz.save(pruebaEntity);
    }
}
