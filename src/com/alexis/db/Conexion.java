package com.alexis.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.alexis.db.ConstantDB.*;

public class Conexion {

    public Conexion(){}

    public Connection conectar(){
        Connection connection = null;
        try{
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            connection = DriverManager.getConnection(URL+DB,USER,PASSWORD);
            System.out.println("conexion establecida");
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;
    }
}
