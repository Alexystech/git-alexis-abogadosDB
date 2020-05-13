package com.alexis.dev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.alexis.db.Conexion;
import com.alexis.db.ConstantDB;
import com.alexis.dev.Constants;

public class ProcuradorDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public ProcuradorDialog() {
        setTitle("Procurador");
        setSize(400,300);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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
                    try
                    {
                        myStateMent = myConnection.conectar().createStatement();
                        ResultSet myResultSet = myStateMent.executeQuery("SELECT * FROM procurador");

                        while(myResultSet.next())
                        {
                            if (Integer.parseInt(textField1.getText().toString()) == myResultSet.getInt(
                                    ConstantDB.TPROCURADOR_PROCURADORDNI))
                            {
                                isEqual = true;
                            }
                        }

                        if (isEqual)
                        {
                            JOptionPane.showMessageDialog(null,"este DNI ya ha sido registrado antes",
                                    "alert",JOptionPane.INFORMATION_MESSAGE);
                        }
                        else
                        {
                            Constants.procuradorDNI         = Integer.parseInt(textField1.getText());
                            Constants.nombreProcurador      = textField2.getText();
                            Constants.direccionProcurador   = textField3.getText();

                            AsuntoDialog myAsunto = new AsuntoDialog();
                            myAsunto.setVisible(true);
                            setVisible(false);
                        }
                    }
                    catch (SQLException throwables)
                    {
                        throwables.printStackTrace();
                    }
                }
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        ProcuradorDialog dialog = new ProcuradorDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
