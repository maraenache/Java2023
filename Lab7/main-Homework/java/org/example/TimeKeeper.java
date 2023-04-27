package org.example;

public class TimeKeeper implements Runnable {

    private final Exploration explore;
    private final int timeLimitSeconds;

    public TimeKeeper(Exploration explore, int timeLimitSeconds) {
        this.explore = explore;
        this.timeLimitSeconds = timeLimitSeconds;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long time = (System.currentTimeMillis() - startTime) / 1000;
            if (time % 5 == 0) {
                System.out.println("Timp trecut: " + time + " secunde");
            }
            if (time >= timeLimitSeconds) {
                System.out.println("Timpul de explorare a trecut...");
                explore.stop();
                return;
            }
            try {
                Thread.sleep(1000); // update display every 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
