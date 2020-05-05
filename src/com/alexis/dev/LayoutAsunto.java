package com.alexis.dev;

import com.alexis.db.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
         * me falta traer la informacion necesaria de
         * la base de datos para llenar los campos
         * DNIcliente y DNIprocurador especificamente de
         * alguna variable 'static' que planeo declarar,
         * donde me almacene el DNIcliente y el
         * DNIprocurador.
         * */

        /**
         * tengo que comprobar que el tipo de dato
         * almacenado por el LocalDate funciona para hacer
         * el registro a la tabla de la bace de datos
         * */

        INSERTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inicioDia    = Integer.parseInt(comboBox2.getSelectedItem().toString());
                int inicioMes    = Integer.parseInt(comboBox3.getSelectedItem().toString());
                int inicioAnio   = Integer.parseInt(comboBox4.getSelectedItem().toString());

                int archivoDia   = Integer.parseInt(comboBox5.getSelectedItem().toString());
                int archivoMes   = Integer.parseInt(comboBox6.getSelectedItem().toString());
                int archivoAnio  = Integer.parseInt(comboBox7.getSelectedItem().toString());

                boolean estadoAsunto = comboBox1.getSelectedItem().toString() == "vigente";

                LocalDate fechaInicio = LocalDate.of(inicioAnio,inicioMes,inicioDia);
                LocalDate fechaArchivo = LocalDate.of(archivoAnio,archivoMes,archivoDia);

                //System.out.println(fechaInicio.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
                //System.out.println(fechaArchivo.format(DateTimeFormatter.ofPattern("dd/MM/yy")));

            }
        });
    }
}
