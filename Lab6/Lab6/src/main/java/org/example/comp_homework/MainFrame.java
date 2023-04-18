package org.example.compulsory;

import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {
    JFrame frame;
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        frame = new JFrame("Laborator 6");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        init();
    }

    private void init() {

        configPanel = new ConfigPanel(this);
        canvas = new DrawingPanel(this);
        controlPanel = new ControlPanel(this);

        controlPanel.setBackground(Color.darkGray);
        configPanel.setBackground(Color.pink);
        canvas.setBackground(Color.lightGray);

        frame.add(canvas, BorderLayout.CENTER);
        frame.add(configPanel, BorderLayout.NORTH);
        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        frame.pack();
    }
}
