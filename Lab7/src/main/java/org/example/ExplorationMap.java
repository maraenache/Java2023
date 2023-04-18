package org.example;

import java.util.List;

public class ExplorationMap {
    private final Cell[][] matrix;
    public final int n;
    public int unvisitedCells;

    public ExplorationMap(int n) {
        this.n = n;
        unvisitedCells = n * n;
        matrix = new Cell[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new Cell(i, j);
            }
        }
    }

    public synchronized boolean visit(int row, int col, Robot robot) {
        Cell cell = matrix[row][col];
        synchronized (cell) {
            if (!cell.isVisited()) {
                List<Token> tokens = robot.getSharedMemory().extractTokens(n);
                cell.addTokens(tokens);
                cell.setVisited(true);
                unvisitedCells--;
                System.out.println(robot.getName() + " visited cell (" + row + "," + col + ") and extracted " + tokens.size() + " tokens: " + tokens);
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j].isVisited() ? "V " : "U ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}