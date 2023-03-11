package lab2.bonus;

public class Country extends Road {
    int numberOfElectricPoles;

    public Country() {
        super();
        this.type = "Country";
    }

    public Country(String name, Location l1, Location l2, int numberOfElectricPoles) {
        super(name, "Country", l1, l2);
        this.numberOfElectricPoles = numberOfElectricPoles;
        this.type = "Country";
    }

    public Country(String name, Location l1, Location l2, int speedLimit, double length, int numberOfElectricPoles) {
        super(name, "Country", l1, l2, speedLimit, length);
        this.numberOfElectricPoles = numberOfElectricPoles;
        this.type = "Country";
    }

    public int getNumberOfElectricPoles() {
        return numberOfElectricPoles;
    }

    public void setNumberOfElectricPoles(int numberOfElectricPoles) {
        this.numberOfElectricPoles = numberOfElectricPoles;
    }
}
