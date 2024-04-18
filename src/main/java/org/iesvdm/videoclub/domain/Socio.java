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
    private int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String dni;
    private String nombre;
    private String apellidos;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "tarjeta",foreignKey = @ForeignKey(name = "FK_TARJETA"),referencedColumnName = "id")

    private Tarjeta tarjeta;
}
