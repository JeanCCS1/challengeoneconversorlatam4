package com.jean;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;

public class Button extends JButton {

    public Button(String name) {
        super(name);
        setFocusable(false);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public void Click(ActionListener click){
        addActionListener(click);
    }
}
