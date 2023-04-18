package org.example.compulsory;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Node> nodes;
    private List<Line> lines;
    private boolean redTurn;

    public Game(List<Node> nodes, List<Line> lines) {
        this.nodes = nodes;
        this.lines = lines;
        this.redTurn = true;
    }

    public boolean isRedTurn() {
        return redTurn;
    }

    public void setRedTurn(boolean redTurn) {
        this.redTurn = redTurn;
    }



}
