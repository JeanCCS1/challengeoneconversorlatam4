package com.jean;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Intefraz extends JFrame {

    private JPanel cardPanel;
    private Stack<JPanel> panels = new Stack<JPanel>();
    public Intefraz(String nameWindows,int height, int width) {
        super(nameWindows);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        cardPanel = new JPanel();
        getContentPane().add(cardPanel);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void add(JPanel panel,String name){
        panels.add(panel);
        cardPanel.removeAll();
        cardPanel.add(panel, name);
        pack();
    }

    public void remove(JPanel panel){
        cardPanel.removeAll();
        if(panels.size()>1)
            panels.pop();
        cardPanel.add(panels.peek());
        pack();
    }


}

