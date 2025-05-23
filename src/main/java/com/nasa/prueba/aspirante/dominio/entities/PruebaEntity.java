package com.nasa.prueba.aspirante.dominio.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class PruebaEntity {
    
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    //href
    @Column(nullable = false)
    private String href;
    //center
    @Column(nullable = false)
    private String center;
    //title
    @Column(nullable = false)
    private String title;
    //nasa_id
    @Column(nullable = false)
    private String nasaId;

    //date_time
    @Column(nullable = false)
    private LocalDateTime dateTimeCreation;
}
