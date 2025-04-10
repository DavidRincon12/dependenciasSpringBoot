package com.veterinaria.consulta;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String motivo;

    private String diagnostico;

    private String tratamiento;

    private Long idMascota;  // Referencia simple (sin relaciones JPA)
}
