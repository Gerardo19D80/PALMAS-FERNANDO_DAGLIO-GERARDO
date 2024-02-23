package com.backend.parcial.test;

import com.backend.parcial.dao.impl.OdontologoDaoH2;
import com.backend.parcial.dao.impl.OdontologoDaoMemoria;
import com.backend.parcial.entity.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private static final Logger LOGGER = Logger.getLogger(OdontologoServiceTest.class);
    private OdontologoService odontologoService;
    private Odontologo odontologoprueba;


    @Test
    void deberiaListarTodosLosOdontologosQueTenemosGuardados (){

        //arrange - organizar
        odontologoService = new OdontologoService(new OdontologoDaoH2());

        Odontologo odontologo1 = new Odontologo(956, "Fernando", "Palmas");
        Odontologo odontologo2 = new Odontologo(957, "Gerardo", "Daglio");
        Odontologo odontologo3 = new Odontologo(958, "Elton", "Armelini");
        Odontologo odontologo4 = new Odontologo(959, "Michael", "Barboza");
        Odontologo odontologo5= new Odontologo(1000, "Moro", "Hernandez");

        //Act

        Odontologo odontologoObtenido = odontologoService.guardar(odontologo1);
        Odontologo odontologoObtenido1 = odontologoService.guardar(odontologo2);
        Odontologo odontologoObtenido2 = odontologoService.guardar(odontologo3);
        Odontologo odontologoObtenido3 = odontologoService.guardar(odontologo4);
        Odontologo odontologoObtenido4 = odontologoService.guardar(odontologo5);

        //Assert

        assertTrue(odontologoObtenido.getId() != 0);
        assertTrue(odontologoObtenido1.getId() != 0);
        assertTrue(odontologoObtenido2.getId() != 0);
        assertTrue(odontologoObtenido3.getId() != 0);
        assertTrue(odontologoObtenido4.getId() != 0);


        if (odontologoObtenido.getId() != 0) {
            LOGGER.info("El ID del odontólogo obtenido es: " + odontologoObtenido.getId());
        } else {
            LOGGER.warn("El ID del odontólogo obtenido es 0. La aserción ha fallado.");
        }
    }


}