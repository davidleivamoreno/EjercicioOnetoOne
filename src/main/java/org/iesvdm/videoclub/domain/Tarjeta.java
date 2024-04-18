package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numero;
    private Date caducidad;
//    @OneToOne
//    @JoinColumn(name = "socio",foreignKey = @ForeignKey(name = "FK_SOCIO"),referencedColumnName = "id")
//    Socio socio;

}
