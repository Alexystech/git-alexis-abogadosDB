package com.alexis.dev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.alexis.db.Conexion;
import com.alexis.db.ConstantDB;
import com.alexis.dev.Constants;

public class FirstLayoutDB extends JFrame{
    private JPanel clientePanel;
    private JButton INSERTARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public FirstLayoutDB () {
        add(clientePanel);
        setTitle("CLIENTE");
        setSize(500,500);

        Conexion connectionToDB = new Conexion();

        INSERTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.clienteDNI        = Integer.parseInt(textField3.getText());
                Constants.nombreCliente     = textField2.getText();
                Constants.direccionCliente  = textField1.getText();


                /**
                try(Connection connection = connectionToDB.conectar()){
                    Statement myStatement = connection.createStatement();
                    String query = "INSERT INTO "+ConstantDB.TCLIENTE+" ("+ConstantDB.TCLIENTE_CLIENTEDNI+", "+
                            ConstantDB.TCLIENTE_NOMBRE+", "+
                            ConstantDB.TCLIENTE_DIRECCION+") VALUES ( '"+clienteDNI+"'"+
                            ", '"+clienteNombre+"'"+
                            ", '"+clienteDireccion+"'"+" )";
                    if (myStatement.executeUpdate(query) > 0)
                    {
                        System.out.println("Nueva tupla!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                 */
                LayoutProcurador procuradorLayout = new LayoutProcurador();
                procuradorLayout.setVisible(true);

                setVisible(false);
            }
        });
    }
}
