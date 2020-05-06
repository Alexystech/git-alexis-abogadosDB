package com.alexis.dev;

import com.alexis.db.Conexion;
import com.alexis.db.ConstantDB;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

import com.alexis.dev.Constants;

/**
 * esta clase pertenece al procurador,
 * esta la utilizo para hacer registros
 * en la tabla procurador de la base de datos
 * */

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
                Constants.procuradorDNI         = Integer.parseInt(textField1.getText());
                Constants.nombreProcurador      = textField2.getText();
                Constants.direccionProcurador   = textField3.getText();

                /**
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
                 */
                LayoutAsunto asuntoLayout = new LayoutAsunto();
                asuntoLayout.setVisible(true);
                setVisible(false);
            }
        });
    }
}
