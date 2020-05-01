package com.alexis.dev;

import com.alexis.db.Conexion;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

import com.alexis.db.ConstantDB;

public class MainClass {

    public static void main(String[] args) throws SQLException{

        Conexion cnx = new Conexion();

        Statement myStatement = cnx.conectar().createStatement();
        ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM cliente");

        while (myResultSet.next()) {
            System.out.println(myResultSet.getString(ConstantDB.TCLIENTE_NOMBRE));
        }

        /**FirstLayoutDB myFirstLayout = new FirstLayoutDB();

        myFirstLayout.setVisible(true);


        LayoutProcurador layoutProcurador = new LayoutProcurador();

        layoutProcurador.setVisible(true);*/

        LayoutAsunto layoutAsunto = new LayoutAsunto();

        layoutAsunto.setVisible(true);
    }

}
