package com.backend.parcial;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.*;

public class Application {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/palmasdaglio;INIT=RUNSCRIPT FROM 'create.sql'", "user1", "pass1");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
