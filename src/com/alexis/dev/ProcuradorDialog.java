package com.alexis.dev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                Constants.procuradorDNI         = Integer.parseInt(textField1.getText());
                Constants.nombreProcurador      = textField2.getText();
                Constants.direccionProcurador   = textField3.getText();

                AsuntoDialog myAsunto = new AsuntoDialog();
                myAsunto.setVisible(true);
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
        ProcuradorDialog dialog = new ProcuradorDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
