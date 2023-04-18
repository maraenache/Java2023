package org.example.compulsory;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    MainFrame frame;
    private double probability;
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

    public int getNumberVertices() {
        return dotsNumber;
    }
    public void setNumberVertices(int dotsNumber) {
        this.dotsNumber = dotsNumber;
    }

    private void init() {
        setNumberVertices(6);
        dotsNumber=6;
        dotsLabel = new JLabel("Number of dots:");
        dotsSpinner = new JSpinner(new SpinnerNumberModel(6, 3, 100, 1));
        dotsSpinner.addChangeListener(e -> {
            int numDots = (int) dotsSpinner.getValue();
            setNumberVertices(numDots);
            frame.canvas.createBoard();
        });

        linesLabel = new JLabel("Line Probability:");
        Double[] probabilities = {0.0, 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
        linesComboBox = new JComboBox<>(probabilities);
        linesComboBox.addActionListener(e -> {
            Double selectedProbability = (Double) linesComboBox.getSelectedItem();
            System.out.println("Selected Probability: " + selectedProbability);
            setProbability(selectedProbability);

            frame.canvas.createBoard();
        });
        createButton = new JButton("Create new game");

        add(dotsLabel);
        add(dotsSpinner);
        add(linesLabel);
        add(linesComboBox);
        add(createButton);
    }
}
