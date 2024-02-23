package com.backend.parcial.test;

import com.backend.parcial.dao.impl.OdontologoDaoH2;
import com.backend.parcial.dao.impl.OdontologoDaoMemoria;
import com.backend.parcial.entity.Odontologo;
import com.backend.parcial.service.OdontologoService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {

    private OdontologoService odontologoService;

    @Test
    void deberiaListarTodosLosOdontologosQueTenemosGuardados (){

        //arrange - organizar

        odontologoService = new OdontologoService(new OdontologoDaoH2());

        Odontologo odontologoAPersistir = new Odontologo(1000, "Fernando", "Palmas");
        //Act
        Odontologo odontologoPersistido = odontologoService.guardar(odontologoAPersistir);
        //Assert
        assertNotNull(odontologoPersistido.getId());

        //creando odontologos
        //Odontologo odontologo1 = new Odontologo(956, "Fernando", "Palmas");
        //Odontologo odontologo2 = new Odontologo(957, "Gerardo", "Daglio");
        //Odontologo odontologo3 = new Odontologo(958, "Elton", "Armelini");
        //Odontologo odontologo4 = new Odontologo(959, "Michael", "Barboza");
        //Odontologo odontologo5= new Odontologo(1000, "Moro", "Hernandez");

        //Act
        //Odontologo odontologoObtenido = odontologoService.guardar(odontologo1);
        //Odontologo odontologoObtenido1 = odontologoService.guardar(odontologo2);
        //Odontologo odontologoObtenido2 = odontologoService.guardar(odontologo3);
        //Odontologo odontologoObtenido3 = odontologoService.guardar(odontologo4);
        //Odontologo odontologoObtenido4 = odontologoService.guardar(odontologo5);

        //Assert
        //assertNotNull(odontologoObtenido.getId());
        //assertNotNull(odontologoObtenido1.getId());
        //assertNotNull(odontologoObtenido2.getId());
        //assertNotNull(odontologoObtenido3.getId());
        //assertNotNull(odontologoObtenido4.getId());


    }


}