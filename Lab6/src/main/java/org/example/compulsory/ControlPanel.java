package org.example.compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");

    JButton saveBtn = new JButton("Save");

    JButton resetBtn = new JButton("Reset");

    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);

        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);

        this.loadBtn.setBackground(Color.CYAN);
        this.saveBtn.setBackground(Color.GREEN);
        this.resetBtn.setBackground(Color.YELLOW);
        this.exitBtn.setBackground(Color.RED);
    }

    private void saveGame(ActionEvent actionEvent) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save:");
        if (fileChooser.showSaveDialog(this.frame) == 0) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());


            try {
                ImageIO.write(this.frame.canvas.createImage(), "png", new FileOutputStream(fileToSave.getAbsolutePath()));
            } catch (IOException exception) {
                System.err.println(exception.getMessage());
            }
        }
    }

    private void loadGame(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load from:");
        if (fileChooser.showOpenDialog(this.frame) == 0) {
            File loadFile = fileChooser.getSelectedFile();
            System.out.println("Loading file: " + loadFile.getAbsolutePath());

            try {
                BufferedImage image = ImageIO.read(loadFile);
                this.frame.canvas.loadImage(image);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

    }

    private void resetGame(ActionEvent actionEvent) {
        this.frame.canvas.createOffscreenImage();
    }

    private void exitGame(ActionEvent actionEvent) {
        frame.dispose();

    }

}
