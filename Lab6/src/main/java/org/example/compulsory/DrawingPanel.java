package org.example.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    private int numVertices;
    private static Integer H = 600;
    private static Integer W = 500;
    private double edgeProbability;
    private int[] x, y;
    BufferedImage image;
    Graphics2D graphics;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        this.createOffscreenImage();
        this.initPanel();
        createBoard();
    }

    protected void createOffscreenImage() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        W = (int) screenSize.getHeight();
        H = (int) screenSize.getWidth();
        this.image = new BufferedImage(W, H, 2);
        this.graphics = this.image.createGraphics();
        this.graphics.setColor(Color.WHITE);
        this.graphics.fillRect(0, 0, W, H);
    }

    protected void initPanel() {
        setPreferredSize(new Dimension(W - 100, H - 250));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                //TODO...
                repaint();
            }
        });
    }

    final void createBoard() {
        createOffscreenImage();
        createVertices();
        repaint();
    }

    public BufferedImage createImage() {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();
        paint(g2d);
        g2d.dispose();
        return image;
    }
    private void createVertices() {
        int dotRadius = 4;
        int x0 = W / 2;
        int y0 = H / 2; //middle of the board
        int radius = Math.min(getWidth(), getHeight()) / 2 - 2 * dotRadius;
        double alpha = 2 * Math.PI / numVertices; // the angle
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
        }
        Point[] vertices = new Point[numVertices];
        for (int i = 0; i < numVertices; i++) {
            double angle = 2 * Math.PI * i / numVertices;
            int x = (int) (x0 + radius * Math.cos(angle));
            int y = (int) (y0 + radius * Math.sin(angle));
            vertices[i] = new Point(x, y);
        }
    }

    //Draw the offscreen image, using the original graphics
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        numVertices = (Integer) frame.configPanel.getNumberVerticies();
        edgeProbability = (Double) frame.configPanel.linesComboBox.getSelectedItem();
        // coordinates of the dots
        int dotRadius = 4;
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(getWidth(), getHeight()) / 2 - 2 * dotRadius;
        Point[] vertices = new Point[numVertices];
        for (int i = 0; i < numVertices; i++) {
            double angle = 2 * Math.PI * i / numVertices;
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));
            vertices[i] = new Point(x, y);
        }

        g.setColor(Color.BLUE);
        for (Point vertex : vertices) {
            int x = vertex.x;
            int y = vertex.y;
            g.fillOval(x - dotRadius, y - dotRadius, dotRadius * 2, dotRadius * 2);
        }

        // draw the lines
        g.setColor(Color.RED);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) { // random probability of drawing a line between two dots
                    g.drawLine(vertices[i].x, vertices[i].y, vertices[j].x, vertices[j].y);
                }
            }
        }
    }

    public void loadImage(BufferedImage image) {
        this.graphics.drawImage(image, 0, 0, (ImageObserver) null);
        this.repaint();
    }
}

