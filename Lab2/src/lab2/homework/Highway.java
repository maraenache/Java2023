package lab2.homework;

public class Highway extends Road {
    int numberOfIndicationSigns;

    public Highway() {
        super();
        this.type="Highway";
    }

    public Highway(String name, Location l1, Location l2, int numberOfIndicationSigns) {
        super(name, "Highway", l1, l2);
        this.numberOfIndicationSigns = numberOfIndicationSigns;
        this.type = "Highway";
    }

    public Highway(String name, Location l1, Location l2, int speedLimit, double length, int numberOfIndicationSigns) {
        super(name, "Highway", l1, l2, speedLimit, length);
        this.numberOfIndicationSigns = numberOfIndicationSigns;
        this.type = "Highway";
    }

    public int getNumberOfIndicationSigns() {

        return numberOfIndicationSigns;
    }

    public void setNumberOfIndicationSigns(int numberOfIndicationSigns) {
        this.numberOfIndicationSigns = numberOfIndicationSigns;
    }
}
