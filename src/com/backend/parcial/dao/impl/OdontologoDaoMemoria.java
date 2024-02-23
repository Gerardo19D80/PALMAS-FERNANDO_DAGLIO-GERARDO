package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.entity.Odontologo;
import org.apache.log4j.Logger;

import java.util.List;

public class OdontologoDaoMemoria implements IDao<Odontologo>{

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoMemoria.class);
    private List<Odontologo> odontologoRepository;

    public OdontologoDaoMemoria(List<Odontologo> odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        int idCreado = odontologoRepository.size() + 1;
        Odontologo nuevoOdontologo = new Odontologo(idCreado, odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());

        odontologoRepository.add(odontologo);
        LOGGER.info("Odontologo guardado: " + nuevoOdontologo);
        return nuevoOdontologo;
    }

    @Override
    public List<Odontologo> listarTodos() {
        LOGGER.info("Listando todos los odontólogos... " + odontologoRepository);
        return odontologoRepository;
    }
}
