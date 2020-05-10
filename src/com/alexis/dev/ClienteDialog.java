package com.alexis.dev;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                Constants.clienteDNI        = Integer.parseInt(textField1.getText());
                Constants.nombreCliente     = textField2.getText();
                Constants.direccionCliente  = textField3.getText();

                ProcuradorDialog myProcurador = new ProcuradorDialog();
                myProcurador.setVisible(true);
                setVisible(false);
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
