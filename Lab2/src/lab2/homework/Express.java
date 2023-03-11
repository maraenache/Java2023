package lab2.homework;

public class Express extends Road {
    private int numberOfLanes;

    public Express() {
        super();
        this.type="Express";
    }

    public Express(String name, Location l1, Location l2, int speedLimit, double length, int numberOfLanes) {
        super(name, "Express", l1, l2, speedLimit, length);
        this.numberOfLanes = numberOfLanes;
        this.type = "Express";
    }

    public Express(String name, Location l1, Location l2, int numberOfLanes) {
        super(name, "Express", l1, l2);
        this.numberOfLanes = numberOfLanes;
        this.type = "Express";
    }

    public int getNumberOfLanes() {
        return numberOfLanes;
    }

    public void setNumberOfLanes(int numberOfLanes) {
        this.numberOfLanes = numberOfLanes;
    }
}
