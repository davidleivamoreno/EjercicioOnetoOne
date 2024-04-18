package org.iesvdm.videoclub;

import jakarta.transaction.Transactional;
import org.iesvdm.videoclub.domain.Comentario;
import org.iesvdm.videoclub.domain.Tutorial;
import org.iesvdm.videoclub.repository.TutorialRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VideoclubApplicationTests {
    @Autowired
    TutorialRepository tutorialRepository;
    @Test
    void contextLoads() {
    }
    @Test
    @Transactional
    void PruebaOnetoManyTutorial(){
     var tutorialList =tutorialRepository.findAll();
     tutorialList.forEach(tutorial ->System.out.println(tutorial));
    }
    @Test
    void pruebaGrabarOnetoMany(){
        Tutorial tutorial=Tutorial.builder()
                        .titulo("Titulo del tutorial")
                        .descripcion("Descripcion").build();
          Comentario comentario1= Comentario.builder()
                                .contenido("texto1")
                                  .build();
        Comentario comentario2= Comentario.builder()
                .contenido("texto2")
                .build();
        tutorialRepository.save(tutorial);
    }

}
