package org.example;


import java.util.ArrayList;
import java.util.List;

public class Robot implements Runnable {
    private volatile boolean paused;
    private volatile long pauseDuration;

    private final String name;
    private final Exploration explore;
    private final List<Token> tokens;
    private boolean running;
    private int numberOfTokens;

    public Robot(String name, Exploration explore) {
        numberOfTokens = 0;
        paused = false;
        pauseDuration = 0L;
        this.name = name;
        this.explore = explore;
        tokens = new ArrayList<>();
    }

    public synchronized void setPaused(boolean paused, long pauseDurationMs) {
        this.paused = paused;
        this.pauseDuration = pauseDurationMs;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public Exploration getExplore() {
        return explore;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public synchronized void stop() {
        running = false;
    }

    // metoda ruleaza cat timp running e true
    // extragem n tokens din shared memory si ii stocam in celula nevizitata
    @Override
    public void run() {
        running = true;
        int n = explore.getMap().matrix.length;
        int row = 0;
        int col = 0;
        while (running) {
            if (explore.getMap().visit(row, col, this)) {
                // extragem tokens din shared memory
                tokens.clear();
                tokens.addAll(explore.getMem().extractTokens(n));
                explore.getMap().matrix[row][col].addAll(tokens);
                if (explore.isStopped()) {
                    break;
                }
                synchronized (this) {
                    numberOfTokens += tokens.size();
                }
                // mergem la urmatoarea coloana
                col++;
                if (col == n) {
                    col = 0;
                    row++;
                }
                try {
                    if (paused) {
                        synchronized (this) {
                            if (pauseDuration == 0L) {
                                wait();
                            } else {
                                wait(pauseDuration);
                            }
                        }
                    } else {
                        Thread.sleep(6000);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            } else {
                col++;
                if (col == n) {
                    col = 0;
                    row++;
                }
            }
        }
    }

}