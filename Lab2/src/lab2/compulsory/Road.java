package lab2.compulsory;

import static java.lang.Math.sqrt;

public class Road {
    private String name;
    private int speedLimit;
    private double length;
    private RoadType type;

    public Road(String name, RoadType type, int speedLimit, Location l1, Location l2) {
        this.speedLimit = speedLimit;
        this.name = name;
        this.type = type;
        this.speedLimit = speedLimit;
        this.length = sqrt((l1.getX() - l2.getX()) * (l1.getX() - l2.getX()) + (l1.getY() - l2.getY()) * (l1.getY() - l2.getY()));
    }

    public Road() {
    }

    public Road(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Road(RoadType type) {
        this.type = type;
    }

    public Road(int speedLimit, double length, RoadType type) {
        this.speedLimit = speedLimit;
        this.length = length;
        this.type = type;
    }


    public Road(String name, int speedLimit, double length, RoadType type) {
        this.name = name;
        this.speedLimit = speedLimit;
        this.length = length;
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Road " + name + "| " +
                "speedLimit=" + speedLimit +
                ", length=" + length +
                ", type=" + type;
    }
}
