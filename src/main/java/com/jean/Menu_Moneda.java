package com.jean;
import java.util.Map;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu_Moneda extends Menu_Convertidor {
    private Map<String, String> unidades;
    private MonedaConvertidor convertidor;

    public Menu_Moneda(Intefraz intefraz) {
        super(intefraz,"Monedas");
        convertidor = new MonedaConvertidor();
        unidades = convertidor.getSupportedUnits();
        if(unidades == null){
            JOptionPane.showMessageDialog(null, "Error, No se puedo conectarse al servidor",
             "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Vector<String> nombreUnidades = new Vector<String>(unidades.values());
        comboBoxConvertidor1.setModel(new DefaultComboBoxModel<>(nombreUnidades));
        comboBoxConvertido2.setModel(new DefaultComboBoxModel<>(nombreUnidades));
        comboBoxConvertidor1.setSelectedIndex(1);
        TextboxConvertidor1.setText("1");

        TextboxConvertido2.setText(Double.toString(convertidor.getconvert(getKeyByValue(comboBoxConvertido2.getSelectedItem().toString()),
        getKeyByValue(comboBoxConvertidor1.getSelectedItem().toString()), 1.0)));
        TextboxConvertido2.getDocument().addDocumentListener(insertUpdateTextboxConvertido2());
        TextboxConvertidor1.getDocument().addDocumentListener(insertUpdateTextboxConvertidor1()); 
        comboBoxConvertidor1.addActionListener(ChangeValueCombobox1());
        comboBoxConvertido2.addActionListener(ChangeValueCombobox2());
    }

    private String getKeyByValue(String value) {
        for (Map.Entry<String, String> entry : unidades.entrySet()) {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    protected DocumentListener insertUpdateTextboxConvertidor1() {
        DocumentListener documentListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {
                if(!isNumeric(TextboxConvertidor1.getText())){
                    JOptionPane.showMessageDialog(null, "Valor no valido",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clearAllDocument(TextboxConvertido2);
                
                TextboxConvertido2.setText(Double.toString(convertidor.getconvert(getKeyByValue(comboBoxConvertido2.getSelectedItem().toString()),
                getKeyByValue(comboBoxConvertidor1.getSelectedItem().toString()),Double.parseDouble(TextboxConvertidor1.getText())))); 

                TextboxConvertido2.getDocument().addDocumentListener(insertUpdateTextboxConvertido2());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(!isNumeric(TextboxConvertidor1.getText())){
                    JOptionPane.showMessageDialog(null, "Valor no valido",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clearAllDocument(TextboxConvertido2);
                
                TextboxConvertido2.setText(Double.toString(convertidor.getconvert(getKeyByValue(comboBoxConvertido2.getSelectedItem().toString()),
                getKeyByValue(comboBoxConvertidor1.getSelectedItem().toString()),Double.parseDouble(TextboxConvertidor1.getText())))); 

                TextboxConvertido2.getDocument().addDocumentListener(insertUpdateTextboxConvertido2());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                
            }
        };
        return documentListener;
    }
    @Override
    protected DocumentListener insertUpdateTextboxConvertido2() {
        DocumentListener documentListener = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {

                if(!isNumeric(TextboxConvertido2.getText())){
                    JOptionPane.showMessageDialog(null, "Valor no valido",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clearAllDocument(TextboxConvertidor1);
                
                TextboxConvertidor1.setText(Double.toString(convertidor.getconvert(getKeyByValue(comboBoxConvertidor1.getSelectedItem().toString()),
                getKeyByValue(comboBoxConvertido2.getSelectedItem().toString()),Double.parseDouble(TextboxConvertido2.getText())))); 

                TextboxConvertidor1.getDocument().addDocumentListener(insertUpdateTextboxConvertidor1());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if(!isNumeric(TextboxConvertido2.getText())){
                    JOptionPane.showMessageDialog(null, "Valor no valido",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clearAllDocument(TextboxConvertidor1);
                
                TextboxConvertidor1.setText(Double.toString(convertidor.getconvert(getKeyByValue(comboBoxConvertidor1.getSelectedItem().toString()),
                getKeyByValue(comboBoxConvertido2.getSelectedItem().toString()),Double.parseDouble(TextboxConvertido2.getText())))); 

                TextboxConvertidor1.getDocument().addDocumentListener(insertUpdateTextboxConvertidor1());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
            }
        };
        return documentListener;
    }


    protected ActionListener ChangeValueCombobox1(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!isNumeric(TextboxConvertidor1.getText())){
                    JOptionPane.showMessageDialog(null, "Valor no valido",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clearAllDocument(TextboxConvertido2);
                
                TextboxConvertido2.setText(Double.toString(convertidor.getconvert(getKeyByValue(comboBoxConvertido2.getSelectedItem().toString()),
                getKeyByValue(comboBoxConvertidor1.getSelectedItem().toString()),Double.parseDouble(TextboxConvertidor1.getText())))); 

                TextboxConvertido2.getDocument().addDocumentListener(insertUpdateTextboxConvertido2());
            }
        };
    }
    protected ActionListener ChangeValueCombobox2(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(!isNumeric(TextboxConvertido2.getText())){
                    JOptionPane.showMessageDialog(null, "Valor no valido",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                clearAllDocument(TextboxConvertidor1);
                
                TextboxConvertidor1.setText(Double.toString(convertidor.getconvert(getKeyByValue(comboBoxConvertidor1.getSelectedItem().toString()),
                getKeyByValue(comboBoxConvertido2.getSelectedItem().toString()),Double.parseDouble(TextboxConvertido2.getText())))); 

                TextboxConvertidor1.getDocument().addDocumentListener(insertUpdateTextboxConvertidor1());
                
            }
        };
    }

}
