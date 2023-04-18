package org.example.compulsory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel implements MouseListener {

    MainFrame frame;
    static int W = 1280, H = 540;
    private int[] x, y;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the tools needed to draw in the image
    private int numVertices = 0;
    private int nrMuchii = 0;
    private int nrVarfuri = 0;
    private double edgeProbability;
    private ArrayList[] adjacentNodes;
    private boolean[][] muchieColorata;
    private boolean stopGame;
    private int currentPlayerIndex;
    private List<Line> lines = new ArrayList<>();
    private List<Node> nodes = new ArrayList<>();
    private Color firstColor = Color.red;
    private Color secondColor = Color.blue;
    private static Color currentPlayerColor;


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        initPanel();
        createBoard();
        addMouseListener(this);
    }

    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setColor(Color.lightGray);
        graphics.fillRect(0, 0, W, H);
    }


    private void initPanel() {
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
    }

    final void createBoard() {
        numVertices = (Integer) frame.configPanel.getNumberVertices();
        edgeProbability = (Double) frame.configPanel.getProbability();
        createOffscreenImage();
        createVertices();
        initComponents();
        drawLines();
        drawVertices();
        addMouseListener(this);
        repaint();
    }

    private void createVertices() {
        int x0 = W / 2;
        int y0 = H / 2;
        int radius = H / 2 - 8;
        double alpha = 2 * Math.PI / numVertices;
        x = new int[numVertices];
        y = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            x[i] = x0 + (int) (radius * Math.cos(alpha * i));
            y[i] = y0 + (int) (radius * Math.sin(alpha * i));
            Node n1 = new Node(x[i], y[i]);
            nodes.add(n1);
            nrVarfuri++;
        }
    }

    //dupa o mutare se schimba indexul
    public void NextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
        if (currentPlayerIndex == 0) currentPlayerColor = firstColor;
        else currentPlayerColor = secondColor;

    }

    private void initComponents() {
        stopGame = false;
        currentPlayerIndex = 1;
        currentPlayerColor = firstColor;
        adjacentNodes = new ArrayList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjacentNodes[i] = new ArrayList<>();
        }
        muchieColorata = new boolean[numVertices][numVertices];
    }

    private void drawVertices() {
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < numVertices; i++) {
            graphics.drawOval(x[i] - 4, y[i] - 4, 8, 8);
            graphics.fillOval(x[i] - 4, y[i] - 4, 8, 8);
        }
    }

    private ArrayList<Integer> findConnectedNodes(int x1, int y1, int x2, int y2) {
        ArrayList<Integer> connectedNodes = new ArrayList<Integer>();
        for (int i = 0; i < numVertices; i++) {
            double distance = Math.abs((y2 - y1) * x[i] - (x2 - x1) * y[i] + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
            if (distance < 5) {
                connectedNodes.add(i);
            }
        }
        return connectedNodes;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (stopGame) {
            System.out.println("Sfarsitul jocului");
        } else {
            for (int i = 0; i < numVertices - 1; i++) {
                for (int j = i + 1; j < numVertices; j++) {
                    int x1 = x[i], y1 = y[i]; // x1,y1-coord nod1
                    int x2 = x[j], y2 = y[j]; // x2,y2-coord nod2
                    double distance = Math.abs((y2 - y1) * e.getX() - (x2 - x1) * e.getY() + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
                    if (distance < 5) {
                        ArrayList<Integer> connectedNodes = findConnectedNodes(x1, y1, x2, y2);
                        //Linia intre nodurile  i si j
                        //daca am adiacenta intre nodurile i si h=j si muchia dintre ele nu e colorata si a fost selectat, ii sch cul, n culoarea playerului curent
                        if (adjacentNodes[i].contains(j) && muchieColorata[i][j] == false && muchieColorata[j][i] == false) {
                            for (int m = 0; m < nrMuchii; m++) {
                                if (lines.get(m).getN1().getX() == x[
                                        i] && lines.get(m).getN1().getY() == y[i]
                                        && lines.get(m).getN2().getX() == x[j] && lines.get(m).getN2().getY() == y[j])
                                    if (currentPlayerIndex == 1) {
                                        lines.get(m).setColor(firstColor);
                                        graphics.setColor(firstColor);
                                        muchieColorata[i][j] = true;
                                        muchieColorata[j][i] = true;

                                    } else {
                                        lines.get(m).setColor(secondColor);
                                        graphics.setColor(secondColor);
                                        muchieColorata[i][j] = true;
                                        muchieColorata[j][i] = true;
                                    }
                            }
                            graphics.drawLine(x[i], y[i], x[j], y[j]);
                            repaint();
                            stopGame();
                            NextPlayer();
                        } else System.out.println(" aici");
                        System.out.println("Connected nodes: " + connectedNodes);
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
    public boolean stopGame() {
        // loop through every combination of three nodes
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                for (int k = j + 1; k < numVertices; k++) {
                    // check if the three nodes form a triangle
                    if (adjacentNodes[i].contains(j) && muchieColorata[i][j] &&
                            adjacentNodes[j].contains(k) && muchieColorata[j][k] &&
                            adjacentNodes[k].contains(i) && muchieColorata[k][i]) {
                        Color color1 = Color.pink, color2 = Color.orange, color3 = Color.green;
                        for (int m = 0; m < nrMuchii; m++) {
                            if (lines.get(m).getN1().getX() == x[i] && lines.get(m).getN1().getY() == y[i]
                                    && lines.get(m).getN2().getX() == x[j] && lines.get(m).getN2().getY() == y[j]) {
                                color1 = lines.get(m).getColor();
                            }
                        }
                        // gasesc linia j-k in lines
                        for (int m = 0; m < nrMuchii; m++) {
                            if (lines.get(m).getN1().getX() == x[j] && lines.get(m).getN1().getY() == y[j]
                                    && lines.get(m).getN2().getX() == x[k] && lines.get(m).getN2().getY() == y[k]) {
                                // daca respecta -> am gasit linie j-k si ii salvez culoarea
                                //System.out.println("LINIA DE LA " + j + " LA " + k + " SI ARE CULOAREA " + lines.get(m).getColor());

                                color2 = lines.get(m).getColor();
                            }
                        }
                        // gasesc linia k-i in lines
                        for (int m = 0; m < nrMuchii; m++) {
                            if (lines.get(m).getN1().getX() == x[i] && lines.get(m).getN1().getY() == y[i]
                                    && lines.get(m).getN2().getX() == x[k] && lines.get(m).getN2().getY() == y[k]) {
                                // daca respecta -> am gasit linie j-k si ii salvez culoarea
                                System.out.println("AM GASIT LINIA DE LA semn" + k + " LA " + i + " SI ARE CULOAREA " + lines.get(m).getColor());

                                color3 = lines.get(m).getColor();
                            }
                        }
                        if (color1 == color2 && color2 == color3) {
                            stopGame = true;
                            return true;
                        }

                    }
                }
            }
        }
        // daca nu gasim niciun triunghi de ac culoare sf joc
        return false;
    }

    private void drawLines() {
        graphics.setColor(Color.BLACK);
        for (int i = 0; i < numVertices; i++) {
            for (int j = i + 1; j < numVertices; j++) {
                if (Math.random() < edgeProbability) {
                    graphics.drawLine(x[i], y[i], x[j], y[j]);
                    Node nod1 = new Node(x[i], y[i]);
                    Node nod2 = new Node(x[j], y[j]);
                    Line linie = new Line(nod1, nod2, false, Color.black);
                    lines.add(linie);
                    nrMuchii++;
                    adjacentNodes[i].add(j);
                    adjacentNodes[j].add(i);
                    muchieColorata[i][j] = false;
                    muchieColorata[j][i] = false;
                }
            }
        }
    }


    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
        if (stopGame == true) {
            g.drawString("SFARSITUL JOCULUI", 100, 100);
        }
    }


}