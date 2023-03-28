package org.example.compulsory;

import org.example.compulsory.ConfigPanel;
import org.example.compulsory.ControlPanel;
import org.example.compulsory.DrawingPanel;

import javax.swing.*;

import java.awt.*;

import static java.awt.BorderLayout.*;
public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas = new DrawingPanel(this);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);

        controlPanel.setBackground(Color.darkGray);
        configPanel.setBackground(Color.pink);
        canvas.setBackground(Color.lightGray);

        add(configPanel, NORTH);
        add(controlPanel, SOUTH);
        add(canvas, CENTER);

        pack();
    }
}
