package lab2.bonus;

public class GasStation extends Location {
    private double gasPrice;

    public GasStation(double gasPrice) {
        super();
        this.gasPrice = gasPrice;
        this.type="GasStation";
    }

    public GasStation(String name, double gasPrice) {
        super(name, "GasStation");
        this.gasPrice = gasPrice;
        this.type="GasStation";
    }

    public GasStation(String name, double x, double y, double gasPrice) {
        super(name, "GasStation", x, y);
        this.gasPrice = gasPrice;
        this.type="GasStation";
    }

    public double getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }
}