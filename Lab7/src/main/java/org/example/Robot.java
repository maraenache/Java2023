package org.example;

public class Robot implements Runnable {
    private final String name;
    private final SharedMemory sharedMemory;
    private final ExplorationMap map;
    private boolean running;

    public Robot(String name, SharedMemory sharedMemory, ExplorationMap map) {
        this.name = name;
        this.sharedMemory = sharedMemory;
        this.map = map;
        running = true;
    }

    public String getName() {
        return name;
    }

    public SharedMemory getSharedMemory() {
        return sharedMemory;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void stop() {
        running = false;

    }

    @Override
    public void run() {
        while (running && map.unvisitedCells != 0) {
            int row = (int) (Math.random() * map.n);
            int col = (int) (Math.random() * map.n);
            map.visit(row, col, this);
            try {
                Thread.sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
/* if (map.unvisitedCells == 0) {
            stop();
        }
        */