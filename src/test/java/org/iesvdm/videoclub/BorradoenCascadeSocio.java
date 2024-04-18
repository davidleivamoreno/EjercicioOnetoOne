package org.iesvdm.videoclub;

import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToOne;
import org.iesvdm.videoclub.domain.Socio;
import org.iesvdm.videoclub.domain.Tarjeta;
import org.iesvdm.videoclub.domain.Tutorial;
import org.iesvdm.videoclub.repository.SocioRepository;
import org.iesvdm.videoclub.repository.TarjetaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@SpringBootTest
public class BorradoenCascadeSocio {
    @Autowired
   SocioRepository socioRepository;
    @Autowired
    TarjetaRepository tarjetaRepository;
    @Test
    void PruebaGrabar() throws ParseException {
        Tarjeta tarjeta=Tarjeta.builder()
//        new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-05")
                .numero(0L)
                .caducidad(Date.from(LocalDate.of(1984,12,05).atStartOfDay(ZoneId.systemDefault()).toInstant()))
                .build();
       tarjetaRepository.save(tarjeta);
      Socio socio=Socio.builder()
              .id(0L)
              .dni("12345A")
              .nombre("Goku")
              .apellidos("Son")
              .build();
        socio.setTarjeta(tarjeta);
        socioRepository.save(socio);

    }
    @Test
    void pruebaDeleteSocio(){
        Optional<Socio>socio=socioRepository.findById(0L);
        Socio socio1=socio.get();
//        socio1.setTarjeta(null);
//        socioRepository.save(socio1);
        socioRepository.deleteById( socio.get().getId());
    }

}
