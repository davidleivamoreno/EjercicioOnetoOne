package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String contenido;
    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "tutorial_id_fk",nullable = false,foreignKey = @ForeignKey(name = "FK_TUTORIAL"))
    @ToString.Exclude
    Tutorial tutorial;
}
