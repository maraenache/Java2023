package org.example;

import java.util.Scanner;

public class Command implements Runnable {

    private final Exploration explore;
    private final Scanner scanner;

    public Command(Exploration explore) {
        this.explore = explore;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split(" ");
            if (tokens.length == 0) {
                System.out.println("Invalid command.");
                continue;
            }
            switch (tokens[0]) {
                case "pause":
                    if (tokens.length != 3) {
                        System.out.println(" sintax: pause <robot name> <duration ms>");
                    } else {
                        String robotName = tokens[1];
                        long durationMs = Long.parseLong(tokens[2]);
                        pauseRobot(robotName, durationMs);
                    }
                    break;
                case "resume":
                    if (tokens.length != 2) {
                        System.out.println("sintax: resume <robot name>");
                    } else {
                        String robotName = tokens[1];
                        resumeRobot(robotName);
                    }
                    break;
                case "pauseall":
                    if (tokens.length != 2) {
                        System.out.println("sintax: pauseall <duration ms>");
                    } else {
                        long durationMs = Long.parseLong(tokens[1]);
                        pauseAllRobots(durationMs);
                    }
                    break;
                case "resumeall":
                    if (tokens.length != 1) {
                        System.out.println("sintax: resumeall");
                    } else {
                        resumeAllRobots();
                    }
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private void pauseRobot(String robotName, long durationMs) {
        Robot robot = getRobot(robotName);
        if (robot == null) {
            System.out.println("Robot not found: " + robotName);
            return;
        }
        explore.pauseRobot(robot, durationMs);
    }

    private void resumeRobot(String robotName) {
        Robot robot = getRobot(robotName);
        if (robot == null) {
            System.out.println("Robot not found: " + robotName);
            return;
        }
        explore.resumeRobot(robot);
    }

    private void pauseAllRobots(long durationMs) {
        explore.pauseAllRobots(durationMs);
    }

    private void resumeAllRobots() {
        explore.resumeAllRobots();
    }

    private Robot getRobot(String robotName) {
        for (Robot robot : explore.robots) {
            if (robot.getName().equals(robotName)) {
                return robot;
            }
        }
        return null;
    }
}
