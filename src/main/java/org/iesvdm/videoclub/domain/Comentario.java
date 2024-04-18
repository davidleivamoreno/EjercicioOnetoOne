package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;
    private String contenido;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "tutorial_id_fk",nullable = false,foreignKey = @ForeignKey(name = "FK_TUTORIAL"))
    @ToString.Exclude
    Tutorial tutorial;
}
