package org.example.compulsory;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    double probability;
    int dotsNumber;
    JLabel dotsLabel, linesLabel;
    JSpinner dotsSpinner;
    JComboBox linesComboBox;
    JButton createButton;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    public double getProbability() {

        return probability;
    }

    public void setProbability(double probability) {

        this.probability = probability;
    }

    public int getNumberVerticies() {

        return dotsNumber;
    }

    public void setNumberVerticies(int dotsNumber) {

        this.dotsNumber = dotsNumber;
    }

    private void init() {
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        linesLabel = new JLabel("Line Probability:");
        Double[] probabilities = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
        linesComboBox = new JComboBox<>(probabilities);
        createButton = new JButton("Create new game");

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesComboBox);
        add(createButton);

        linesComboBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Double selectedProbability = (Double) linesComboBox.getSelectedItem();
                System.out.println("Selected Probability: " + selectedProbability);
                setProbability(selectedProbability);
            }
        });

        createButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int numDots = (int) dotsSpinner.getValue();
                Double selectedProbability = (Double) linesComboBox.getSelectedItem();
                System.out.println("Num Dots: " + numDots + ", Selected Probability: " + selectedProbability);
                setProbability(selectedProbability);
                setNumberVerticies(numDots);
            }
        });
    }
}
