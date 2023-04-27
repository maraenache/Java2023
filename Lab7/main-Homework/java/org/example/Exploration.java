package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exploration {
    private final Scanner scanner;
    private final int timeLimitSeconds = 30;

    //pause Robot1 20000
    //pauseall 7000
    //resumeall
    //resume Robot1
    private volatile boolean stopped;
    private final TimeKeeper timeKeeper;

    private volatile boolean paused; // volatile- pastram in memoria principala
    private final SharedMemory mem;
    private final ExplorationMap map;
    protected final List<Robot> robots;

    public Exploration(int n, int numRobots) {
        paused = false;
        scanner = new Scanner(System.in);
        timeKeeper = new TimeKeeper(this, timeLimitSeconds);
        Thread timeKeeperThread = new Thread(timeKeeper);
        timeKeeperThread.setDaemon(true); // set as daemon thread to stop automatically when non-daemon threads exit
        timeKeeperThread.start();
        mem = new SharedMemory(n);
        map = new ExplorationMap(n);
        robots = new ArrayList<>();
        for (int i = 1; i <= numRobots; i++) {
            robots.add(new Robot("Robot" + i, this));
        }
    }

    public void resumeRobot(Robot robot) {
        synchronized (robot) {
            robot.setPaused(false, 0L);
            robot.notify();
        }
    }

    public void pauseAllRobots(long durationMs) {
        setPaused(true);
        for (Robot robot : robots) {
            synchronized (robot) {
                robot.setPaused(true, durationMs);
            }
        }
    }

    public void resumeAllRobots() {
        setPaused(false);
        for (Robot robot : robots) {
            synchronized (robot) {
                robot.setPaused(false, 0L);
                robot.notify();
            }
        }
    }

    private synchronized boolean isPaused() {
        return paused;
    }

    private synchronized void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void pauseRobot(Robot robot, long durationMs) {
        synchronized (robot) {
            robot.setPaused(true, durationMs);
        }
    }

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public synchronized void stop() {
        stopped = true;
        for (Robot robot : robots) {
            robot.stop();
        }
        for (Robot robot : robots) {
            int tokenCount = robot.getNumberOfTokens();
            System.out.println(robot.getName() + " a introdus " + tokenCount + " tokens");
        }
    }

    public boolean isStopped() {
        return stopped;
    }

    public void start() {
        for (Robot robot : robots) {
            new Thread(robot).start();
        }
    }

    public static void main(String[] args) {
        int n = 15, nRobots = 3;
        Exploration exploration = new Exploration(n, nRobots);
        exploration.start();
        Thread commandThread = new Thread(new Command(exploration));
        commandThread.start();
    }
}

