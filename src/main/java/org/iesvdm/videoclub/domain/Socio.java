package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Socio {
    @Id
    private Long id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dni;
    private String nombre;
    private String apellidos;
    @OneToOne
    private Tarjeta tarjeta;
}
