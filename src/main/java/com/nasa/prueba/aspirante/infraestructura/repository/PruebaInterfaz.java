package com.nasa.prueba.aspirante.infraestructura.repository;

import com.nasa.prueba.aspirante.dominio.entities.PruebaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PruebaInterfaz extends JpaRepository<PruebaEntity, Integer> {

}
