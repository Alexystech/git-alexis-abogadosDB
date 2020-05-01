package com.alexis.dev;

import com.alexis.db.Conexion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LayoutAsunto extends JFrame{
    private JPanel layoutAsunto;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JButton INSERTARButton;

    public LayoutAsunto(){
        add(layoutAsunto);
        setTitle("ASUNTO");
        setSize(500,500);

        Conexion connectionToDB = new Conexion();

        INSERTARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fechaInicio = textField3.getText();
            }
        });
    }
}
