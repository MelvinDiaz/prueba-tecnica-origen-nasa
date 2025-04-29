package com.nasa.prueba.aspirante.infraestructura.repository;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PruebaInterfaz extends JpaRepository<PruebaEntity, Integer> {

    List<PruebaEntity> findAllByOrderByIdDesc();
    Page<PruebaEntity> findAllByOrderByIdDesc(Pageable pageable);
}
