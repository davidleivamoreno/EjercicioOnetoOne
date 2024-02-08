package org.iesvdm.videoclub.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tuto")
    private long id;
    @Column(name = "titulo",length = 50)
    private String titulo;
    @Column(name = "descrip",length = 150)
    private String descripcion;

    private boolean publicado;
    @OneToMany(mappedBy = "tutorial",fetch = FetchType.LAZY)
            @OnDelete(action = OnDeleteAction.CASCADE)
    List<Comentario> comentariosList;


}
