package com.alexis.dev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alexis.db.Conexion;
import com.alexis.db.ConstantDB;
import com.alexis.dev.Constants.*;

public class ClienteDialog extends JDialog {
    private JPanel contentPane;
    private JButton CANCELARButton;
    private JButton REGISTRARButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public ClienteDialog() {
        setTitle("Cliente");
        setSize(400,300);
        setContentPane(contentPane);
        setModal(true);
        REGISTRARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /**
                 * uso este algoritmo para tratar errores
                 * primero checo que no este vacio ningun campo,
                 * despues compruevo que el DNI ingresado por el
                 * usuario no sea igual a otro DNI que este
                 * registrado en la base de datos
                 * */
                if (textField1.getText().isEmpty() || textField2.getText().isEmpty() || textField3.getText().isEmpty())
                {
                    JOptionPane.showMessageDialog(null,"llene todos los campos","alert",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    Conexion myConnection = new Conexion();
                    boolean isEqual = false;

                    Statement myStateMent = null;
                    try {
                        myStateMent = myConnection.conectar().createStatement();
                        ResultSet myResultSet = myStateMent.executeQuery("SELECT * FROM cliente");

                        while (myResultSet.next())
                        {
                            if (Integer.parseInt(textField1.getText()) == myResultSet.getInt(
                                    ConstantDB.TCLIENTE_CLIENTEDNI))
                            {
                                isEqual = true;
                            }
                        }

                        if (isEqual)
                        {
                            JOptionPane.showMessageDialog(null,"este DNI ya ha sido registrado antes",
                                    "error",JOptionPane.ERROR_MESSAGE);
                        }
                        else
                        {
                            Constants.clienteDNI        = Integer.parseInt(textField1.getText());
                            Constants.nombreCliente     = textField2.getText();
                            Constants.direccionCliente  = textField3.getText();

                            ProcuradorDialog myProcurador = new ProcuradorDialog();
                            myProcurador.setVisible(true);
                            setVisible(false);
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });
        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        ClienteDialog dialog = new ClienteDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
