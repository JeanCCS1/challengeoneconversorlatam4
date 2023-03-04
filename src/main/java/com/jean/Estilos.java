package com.jean;
import java.awt.Cursor;
import java.util.ArrayList;

import javax.swing.*;

public class Estilos {
    public static void CreateMargen(JComponent control,int margen){
        control.setBorder(BorderFactory.createEmptyBorder(margen,margen,margen,margen));
    }

    public static void CreateMargen(JComponent control,int Horizontal, int Vertical){
        control.setBorder(BorderFactory.createEmptyBorder(Vertical,Horizontal,Vertical,Horizontal));
    }

    public static void CreateMargen(JComponent control,int top, int left,int bottom,int rigth){
        control.setBorder(BorderFactory.createEmptyBorder(top,left,bottom,rigth));
    }

    public static void CreateMargen(ArrayList<JComponent> controls,int Horizontal, int Vertical){
        for (JComponent control : controls) {
            control.setBorder(BorderFactory.createEmptyBorder(Vertical,Horizontal,Vertical,Horizontal));
        }
    }

    public static void CursorHand(JComponent control){
        control.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void CursorHand(ArrayList<JComponent> controls){
        for (JComponent control : controls) {
            control.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    }
}
