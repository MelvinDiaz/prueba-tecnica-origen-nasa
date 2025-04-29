package com.nasa.prueba.aspirante.infraestructura.services;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import com.nasa.prueba.aspirante.infraestructura.repository.PruebaInterfaz;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PruebaService {
    private final PruebaInterfaz pruebaInterfaz;

    public List<PruebaEntity> getAllOrderedByNasaIdDesc() {
        return pruebaInterfaz.findAllByOrderByIdDesc();
    }

    public Page<PruebaEntity> getAllPaginated(Pageable pageable) {
        return pruebaInterfaz.findAllByOrderByIdDesc(pageable);
    }
}
