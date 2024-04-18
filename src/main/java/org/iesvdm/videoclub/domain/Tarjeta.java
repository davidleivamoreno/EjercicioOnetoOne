package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Tarjeta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date caducidad;
//    @OneToOne
//    @JoinColumn(name = "socio",foreignKey = @ForeignKey(name = "FK_SOCIO"),referencedColumnName = "id")
//    Socio socio;

}
