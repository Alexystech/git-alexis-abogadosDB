package com.alexis.dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrincipalLayout extends JFrame{

    private JButton buttonPrincipal;
    private JPanel layoutPrincipal;
    private JButton SUBIRABASEDEButton;

    public static boolean buttonEnable = true;

    public void isButtonEnable(boolean buttonEnable){
        if (buttonEnable) {
            buttonPrincipal.setEnabled(true);
        } else {
            buttonPrincipal.setEnabled(false);
        }
    }

    public PrincipalLayout(){
        add(layoutPrincipal);
        setTitle("PRINCIPAL");
        setSize(400,200);

        isButtonEnable(buttonEnable);

        buttonPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FirstLayoutDB myLayout = new FirstLayoutDB();

                myLayout.setVisible(true);

                buttonEnable = false;
                isButtonEnable(buttonEnable);
            }
        });

        /**
         * necesito hacer que el buttonPrincipal se active al
         * final de el ingreso de los datos
         * */
    }
}
