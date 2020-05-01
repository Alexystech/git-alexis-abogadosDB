package com.alexis.dev;

import com.alexis.db.Conexion;
import com.alexis.db.ConstantDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class LayoutProcurador extends JFrame{
    private JPanel procuradorPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton INSERTButton;

    public LayoutProcurador() {
        add(procuradorPanel);
        setTitle("PROCURADOR");
        setSize(500,500);

        Conexion connectionToDB = new Conexion();


        INSERTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int procuradorDNI           = Integer.parseInt(textField1.getText());
                String procuradorNombre     = textField2.getText();
                String procuradorDireccion  = textField3.getText();

                try (Connection connection = connectionToDB.conectar()){
                    Statement myStatement = connection.createStatement();
                    String query = "INSERT INTO "+ ConstantDB.TPROCURADOR +" ("+ConstantDB.TPROCURADOR_PROCURADORDNI+
                            ", "+ConstantDB.TPROCURADOR_NOMBRE+", "+ConstantDB.TPROCURADOR_DIRECCION+") VALUES ('"+
                            procuradorDNI+"' ,'"+procuradorNombre+"' ,'"+procuradorDireccion+"')";
                    if (myStatement.executeUpdate(query) > 0) {
                        System.out.println("nueva tupla!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
