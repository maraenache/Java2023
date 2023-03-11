package lab2.bonus;

public class Airport extends Location {
    private int numbersOfTerminals;
    public Airport(int numbersOfTerminals) {
        super();
        this.numbersOfTerminals = numbersOfTerminals;
        this.type = "Airport";
    }

    public Airport(String name, int numbersOfTerminals) {
        super(name,"Airport");
        this.numbersOfTerminals = numbersOfTerminals;
        this.type = "Airport";
    }

    public Airport(String name, double x, double y, int numbersOfTerminals) {
        super(name,"Airport", x, y);
        this.numbersOfTerminals = numbersOfTerminals;
        this.type = "Airport";
    }
    public int getNumbersOfTerminals() {
        return numbersOfTerminals;
    }
    public void setNumbersOfTerminals(int numbersOfTerminals) {
        this.numbersOfTerminals = numbersOfTerminals;
    }
}