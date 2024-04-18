package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(
        name = "tutorial",schema = "videoclub_jpa",indexes = {@Index(name = "index_titulo", columnList = "titulo", unique = false)}
)
/*@SequenceGenerator(
        name="TutorialSeq",
        sequenceName="TUTORIAL_SEQ",
        intitialValue=1,
        allocationSize = 10
)*/
public class Tutorial {
    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tuto")
    private long id;
    @Column(name = "titulo",length = 50)
    private String titulo;
    @Column(name = "descrip",length = 150)
    private String descripcion;

    private boolean publicado;
    @OnDelete(action = OnDeleteAction.CASCADE)

    @OneToMany(mappedBy = "tutorial",fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    private Set<Comentario> comentarios;
    public Tutorial addComentario(Comentario comentario){
    comentario.setTutorial(this);
    this.addComentario(comentario);
    return this;
    }
    public Tutorial removeComentario(Comentario comentario){
        this.comentarios.remove(comentario);
        comentario.setTutorial(this);
        return this;
    }

}
