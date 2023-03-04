package com.jean;
import javax.swing.JPanel;
import javax.swing.event.DocumentListener;
import javax.swing.text.AbstractDocument;
import javax.swing.text.Document;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public abstract class Menu_Convertidor extends JPanel {

    protected Intefraz intefraz;    
    protected JTextField TextboxConvertidor1 = new JTextField();
    protected JComboBox<String> comboBoxConvertidor1 = new JComboBox<String>();
    protected JTextField TextboxConvertido2 = new JTextField();
    protected JComboBox<String> comboBoxConvertido2 = new JComboBox<String>();

    public Menu_Convertidor(Intefraz intefraz, String Convertidor) {
        super(new GridLayout(4, 1, 0, 15));
        this.intefraz = intefraz;
        JLabel label = new JLabel("Convertidor de " + Convertidor);
        label.setFont(new Font("SansSerif", Font.BOLD, 25));
        label.setHorizontalAlignment(JLabel.CENTER);


        JPanel panelconvertidor = new JPanel(new GridLayout(1, 2, 5, 0));
        panelconvertidor.add(TextboxConvertidor1);
        panelconvertidor.add(comboBoxConvertidor1);
        

        JPanel panelconvertido = new JPanel(new GridLayout(1, 2, 5, 0));
        panelconvertido.add(TextboxConvertido2);
        panelconvertido.add(comboBoxConvertido2);
        

        Button atras = new Button("Atras");
        atras.Click(atrasClick());
        

        
        Estilos.CreateMargen(label, 10, 0);
        add(label);
        add(panelconvertidor);
        add(panelconvertido);
        add(atras);
    }

    private ActionListener atrasClick(){
        final JPanel actual = this;
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                intefraz.remove(actual);
            }
        };
    }

    protected void clearAllDocument(JTextField textField){
        Document document = textField.getDocument();
        DocumentListener[] listeners = ((AbstractDocument)document).getDocumentListeners();
        for (int i = 0; i < listeners.length-2; i++) {
            document.removeDocumentListener(listeners[i]);
        }
    }

    protected static boolean isNumeric(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    protected abstract DocumentListener insertUpdateTextboxConvertidor1();
    protected abstract DocumentListener insertUpdateTextboxConvertido2();
    protected abstract ActionListener ChangeValueCombobox1();
    protected abstract ActionListener ChangeValueCombobox2();
}
