package com.alexis.dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.alexis.db.Conexion;
import com.alexis.dev.Constants;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import com.alexis.db.ConstantDB;

public class PrincipalLayout extends JFrame{

    private JButton buttonPrincipal;
    private JPanel layoutPrincipal;
    private JButton SUBIRABASEDEButton;

    public PrincipalLayout(){
        add(layoutPrincipal);
        setTitle("PRINCIPAL");
        setSize(400,200);

        buttonPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClienteDialog myClient = new ClienteDialog();

                myClient.setVisible(true);
            }
        });

        SUBIRABASEDEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Constants.isButtonEnable) {
                    /**
                     * aqui tengo que conectar con la base de datos
                     * y hacer los registros correspondientes con los
                     * datos recolectados almacenados en la clase Constants
                     * */
                    Conexion connectionToDB = new Conexion();
                    try (Connection connection = connectionToDB.conectar()){
                        LocalDate fechaInicio = LocalDate.of(Constants.inicioAnio,
                                Constants.inicioMes,
                                Constants.inicioDia
                        );

                        LocalDate fechaArchivo = LocalDate.of(Constants.archivoAnio,
                                Constants.archivoMes,
                                Constants.archivoDia
                        );

                        Statement myStatement = connection.createStatement();
                            String queryCliente = "INSERT INTO "+ ConstantDB.TCLIENTE +" VALUES ( "+
                                    Constants.clienteDNI+", '"+Constants.nombreCliente+"', '"+
                                    Constants.direccionCliente+"' )";

                            String queryProcurador = "INSERT INTO "+ConstantDB.TPROCURADOR+" VALUES ( "+
                                    Constants.procuradorDNI+", '"+Constants.nombreProcurador+"', '"+
                                    Constants.direccionProcurador+"' )";

                            String queryAsunto = "INSERT INTO "+ConstantDB.TASUNTO+" VALUES ( "+
                                    Constants.clienteDNI+", "+Constants.procuradorDNI+
                                    ", '"+fechaInicio+"', '"+fechaArchivo+
                                    "', '"+Constants.estadoAsunto+"')";

                        if (myStatement.executeUpdate(queryCliente) > 0) {
                            System.out.println("nuevo registro cliente");
                        }

                        if (myStatement.executeUpdate(queryProcurador) > 0) {
                            System.out.println("nuevo registro procurador");
                        }

                        if (myStatement.executeUpdate(queryAsunto) > 0) {
                            System.out.println("nuevo registro asunto");
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    Constants.isButtonEnable = false;
                } else {
                    JOptionPane.showMessageDialog(null,"No has llenado los datos"
                            ,"Alert"
                            ,JOptionPane.ERROR_MESSAGE
                    );
                }
            }
        });
    }
}
