package com.jean;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JPanel{
    private Intefraz intefraz;

    public Menu(Intefraz intefraz) {
        this.intefraz = intefraz;
        JLabel label = new JLabel("Menu");
        label.setFont(new Font("SansSerif", Font.BOLD, 25));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        Estilos.CreateMargen(label, 10);
        /* creacion de los botones */
        JPanel contenedorBotones = new JPanel();
        contenedorBotones.setLayout(new GridLayout(1,2,10,0));
        Button ConvertidorMoneda = new Button("Convertidor de moneda");
        contenedorBotones.add(ConvertidorMoneda);
        ConvertidorMoneda.Click(ConvertidorMonedaClick());

        setLayout(new GridLayout(4,1));
        add(label);
        add(contenedorBotones);
    }

    private ActionListener ConvertidorMonedaClick(){
       return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                intefraz.add(new Menu_Moneda(intefraz),"Menu_Moneda");
            }
        };  
    }

}
