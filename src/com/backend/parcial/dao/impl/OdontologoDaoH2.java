package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.dbconnection.H2Connection;
import com.backend.parcial.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        Connection connection = null;
        Odontologo odontologoObtenido = null;

        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (NUMEROMATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.execute();

            //comiteamos
            connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                odontologoObtenido = new Odontologo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
            }

            LOGGER.info("Odontologo: " + odontologoObtenido);
            //connection.setAutoCommit(true);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();

                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                } finally {
                    try {
                        connection.close();
                    } catch (Exception ex) {
                        LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
                    }
                }
            }
        }

            return odontologoObtenido;
        }

    @Override
    public List<Odontologo> listarTodos() {

        Connection connection = null;
        List<Odontologo> odontologos = new ArrayList<>();


    try{
        connection = H2Connection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS");
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            Odontologo odontologo = resultSet;
            odontologos.add(odontologo);
        }

    } catch (Exception e) {
        LOGGER.error(e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            connection.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

        return null;
    }
}
