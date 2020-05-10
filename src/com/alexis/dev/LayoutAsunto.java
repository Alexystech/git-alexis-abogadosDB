package com.alexis.dev;

import com.alexis.db.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.alexis.dev.Constants;

public class LayoutAsunto extends JFrame{
    private JPanel layoutAsunto;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JButton INSERTARButton;
    private JComboBox<String> comboBox2;
    private JComboBox<String> comboBox3;
    private JComboBox<String> comboBox4;
    private JComboBox<String> comboBox5;
    private JComboBox<String> comboBox6;
    private JComboBox<String> comboBox7;

    public LayoutAsunto(){
        add(layoutAsunto);
        setTitle("ASUNTO");
        setSize(500,650);

        Conexion connectionToDB = new Conexion();



        /**
         * tengo que comprobar que el tipo de dato
         * almacenado por el LocalDate funciona para hacer
         * el registro a la tabla de la bace de datos
         * */
        String txtClienteDNI = Integer.toString(Constants.clienteDNI);
        String txtProcuradorDNI = Integer.toString(Constants.procuradorDNI);

        textField1.setText(txtClienteDNI);
        textField2.setText(txtProcuradorDNI);

        INSERTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.inicioDia    = Integer.parseInt(comboBox2.getSelectedItem().toString());
                Constants.inicioMes    = Integer.parseInt(comboBox3.getSelectedItem().toString());
                Constants.inicioAnio   = Integer.parseInt(comboBox4.getSelectedItem().toString());

                Constants.archivoDia   = Integer.parseInt(comboBox5.getSelectedItem().toString());
                Constants.archivoMes   = Integer.parseInt(comboBox6.getSelectedItem().toString());
                Constants.archivoAnio  = Integer.parseInt(comboBox7.getSelectedItem().toString());

                Constants.estadoAsunto = comboBox1.getSelectedItem().toString() == "vigente";

                //LocalDate fechaInicio = LocalDate.of(Constants.inicioAnio,Constants.inicioMes,Constants.inicioDia);
                //LocalDate fechaArchivo = LocalDate.of(Constants.archivoAnio,Constants.archivoMes,Constants.archivoDia);

                /**
                 * la fecha la necesito en la clase donde se va
                 * hacer la tupla para la base de datos
                 * tengo penzado ponerlo en el principalLayout
                 * cuando haga [subir a base de datos]
                 * */

                //System.out.println(fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
                //System.out.println(fechaArchivo.format(DateTimeFormatter.ofPattern("dd/MM/yy")));

                setVisible(false);
            }
        });
    }
}
