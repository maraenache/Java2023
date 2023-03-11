package lab2.bonus;

public class City extends Location {
    private int population;
    public City(int population)
    {
        super();
        this.population=population;
        this.type = "City";
    }
    public City(String name, int population) {
        super(name,"City");
        this.population = population;
        this.type = "City";
    }
    public City(String name, double x, double y, int population) {
        super(name, "City",x, y);
        this.population = population;
        this.type = "City";
    }
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
