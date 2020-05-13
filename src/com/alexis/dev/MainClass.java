package com.alexis.dev;

import com.alexis.db.Conexion;

import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import com.alexis.db.ConstantDB;

public class MainClass {

    public static void main(String[] args) throws SQLException{

        List<Integer> misDNI = new ArrayList<Integer>();
        Conexion cnx = new Conexion();

        Statement myStatement = cnx.conectar().createStatement();
        ResultSet myResultSet = myStatement.executeQuery("SELECT * FROM cliente");

        while (myResultSet.next()) {
            misDNI.add(myResultSet.getInt(ConstantDB.TCLIENTE_CLIENTEDNI));
        }

        for (int x : misDNI)
        {
            System.out.println(x);
        }

        PrincipalLayout principalLayout = new PrincipalLayout();

        principalLayout.setVisible(true);

    }

}
