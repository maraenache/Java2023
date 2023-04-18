package org.example;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory sharedMemory;
    private final ExplorationMap map;
    private final List<Robot> robots;


    public Exploration(int n, int numRobots) {

        sharedMemory = new SharedMemory(n);

        map = new ExplorationMap(n);

        robots = new ArrayList<>();

        for (int i = 1; i <= numRobots; i++) {
            Robot robot = new Robot("Robot " + i, sharedMemory, map);
            robots.add(robot);
        }
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
        while (map.unvisitedCells != 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        stop();
        printMap();
    }

    public void stop() {
        for (Robot robot : robots) {
            robot.stop();
        }
    }

    public void printMap() {
        System.out.println(map);
    }

    public static void main(String[] args) {
        var explore = new Exploration(4,3);
        explore.start();
    }

}
