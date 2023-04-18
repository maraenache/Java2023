package org.example.compulsory;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
    static File filePath = new File("C:/Users/Mara/Documents/img.png");

    JButton newGameBtn= new JButton("Restart");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {

        add(loadBtn);
        add(saveBtn);
        add(resetBtn);
        add(exitBtn);
        add(newGameBtn);

        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        resetBtn.addActionListener(this::resetGame);
        exitBtn.addActionListener(this::exitGame);
        newGameBtn.addActionListener(this::createNewGame);

        this.loadBtn.setBackground(Color.CYAN);
        this.saveBtn.setBackground(Color.GREEN);
        this.resetBtn.setBackground(Color.YELLOW);
        this.exitBtn.setBackground(Color.RED);
    }
    private void createNewGame(ActionEvent e) {
        frame.canvas.createBoard();
    }
    private void saveGame(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", filePath);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
    private void loadGame(ActionEvent e) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to load from:");
        if (fileChooser.showOpenDialog(this.frame) == 0) {
            File loadFile = fileChooser.getSelectedFile();
            System.out.println("Loading file: " + loadFile.getAbsolutePath());

            frame.canvas.createBoard();
            try {
                BufferedImage loadImage = ImageIO.read(loadFile);
                frame.canvas.image = loadImage;
                frame.canvas.graphics = frame.canvas.image.createGraphics();

            } catch (IOException exception) {
                System.err.println(exception);
            }
        }
    }
        private void resetGame (ActionEvent actionEvent){
            frame.configPanel.setNumberVertices(6);
            frame.configPanel.setProbability(0);
            this.frame.canvas.createBoard();
        }

        private void exitGame (ActionEvent actionEvent){
            frame.dispose();
            System.exit(0);
        }

    /*serializare

     public static void saveSerial(Game game, String filepath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(path), game);
    }

    public static Game load(String path) throws InvalidCatalogException {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Game game = objectMapper.readValue(new File(path), Catalog.class);
            return game;
        } catch (IOException e) {
            throw new InvalidCatalogException("Error loading catalog: " + e.getMessage());
        }
    }
    */
}
