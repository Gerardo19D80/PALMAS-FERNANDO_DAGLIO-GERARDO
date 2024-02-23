package com.backend.parcial.dao.impl;

import com.backend.parcial.dao.IDao;
import com.backend.parcial.dbconnection.H2Connection;
import com.backend.parcial.entity.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static final Logger LOGGER = Logger.getLogger(OdontologoDaoH2.class);

    @Override
    public Odontologo registrar(Odontologo odontologo) {

        String insert = "INSERT INTO ODONTOLOGOS (MATRICULA, NOMBRE, APELLIDO) VALUES (?, ?, ?)";
        Connection connection = null;
        Odontologo odontologoObtenido = null;

        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, odontologo.getMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.execute();

            //comiteamos
            connection.commit();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()){
                odontologoObtenido = new Odontologo(resultSet.getInt(1),odontologo.getMatricula(), odontologo.getNombre(), odontologo.getApellido());
            }

            LOGGER.info("Odontologo: " + odontologoObtenido);

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
            Odontologo odontologo = new Odontologo(resultSet.getInt(1), resultSet.getInt(2), resultSet.getString(3), resultSet.getString(4));
            odontologos.add(odontologo);
        }

        LOGGER.info("Listado de odontologos: " + odontologos);

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
        return odontologos;
    }

}
