package org.example;


import java.util.ArrayList;
import java.util.List;

public class Cell {
    private final int row;
    private final int col;
    private final List<Token> tokens;
    private boolean visited;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.tokens = new ArrayList<>();
        this.visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public synchronized void setVisited(boolean visited) {
        this.visited = visited;
    }

    public synchronized void addTokens(List<Token> tokens) {
        this.tokens.addAll(tokens);
    }
}

