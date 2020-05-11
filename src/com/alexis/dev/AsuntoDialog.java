package com.alexis.dev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.alexis.dev.Constants;

public class AsuntoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JComboBox comboBox7;

    public AsuntoDialog() {
        setSize(800,800);
        setTitle("Asunto");
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        textField1.setText(Integer.toString(Constants.clienteDNI));
        textField2.setText(Integer.toString(Constants.procuradorDNI));

        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Constants.inicioDia = Integer.parseInt(comboBox6.getSelectedItem().toString());
                Constants.inicioMes = Integer.parseInt(comboBox5.getSelectedItem().toString());
                Constants.inicioAnio = Integer.parseInt(comboBox4.getSelectedItem().toString());
                Constants.archivoDia = Integer.parseInt(comboBox3.getSelectedItem().toString());
                Constants.archivoMes = Integer.parseInt(comboBox2.getSelectedItem().toString());
                Constants.archivoAnio = Integer.parseInt(comboBox1.getSelectedItem().toString());
                Constants.estadoAsunto = comboBox7.getSelectedItem().toString();

                Constants.isButtonEnable = true;
                setVisible(false);
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
        AsuntoDialog dialog = new AsuntoDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
