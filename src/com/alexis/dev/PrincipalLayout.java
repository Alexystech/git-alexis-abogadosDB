package com.alexis.dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import com.alexis.dev.Constants;

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
                    JOptionPane.showMessageDialog(null,"Funciona"
                            ,"alert"
                            ,JOptionPane.INFORMATION_MESSAGE
                    );
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
