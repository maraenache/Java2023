package org.example;

import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {

    protected final List<Token>[][] matrix;

    public ExplorationMap(int n) {
        matrix = new ArrayList[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }
    }
    // synchronized, ea poate fi accesata de un singur fir de execuție la un moment dat
    // matrice de nxn care contine liste goale in fiecare celula
    //daca celula e goala adauga tokenii de la roboti si returneaza
    // true-> adica celula a fost vizitata, altfel returneaza false
    public synchronized boolean visit(int row, int col, Robot robot) {
        List<Token> tokens = matrix[row][col];
        if (tokens.isEmpty()) {
            tokens.addAll(robot.getTokens());
            System.out.printf("%s visited (%d, %d) and extracted tokens: %s%n",
                    robot.getName(), row, col, tokens);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[ ");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}