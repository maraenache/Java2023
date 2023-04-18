package org.example.compulsory;

import java.awt.*;

public class Line {
    private Node n1;
    private Node n2;
    private boolean colored;
    private Color color;

    public Line(Node n1, Node n2, boolean colored, Color color) {
        this.n1 = n1;
        this.n2 = n2;
        this.colored = colored;
        this.color = color;
    }

    public void setN1(Node n1) {
        this.n1 = n1;
    }

    public void setN2(Node n2) {
        this.n2 = n2;
    }

    public Node getN1() {
        return n1;
    }

    public Node getN2() {
        return n2;
    }

    public boolean isColored() {
        return colored;
    }

    public void setColored(boolean colored) {
        this.colored = colored;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
