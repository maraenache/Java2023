package lab2.compulsory;

public class Location {
    private String name;
    private LocationType type;
    private double x, y;

    public Location() {
    }

    public Location(String name) {
        this.name = name;
    }

    public Location(LocationType type) {
        this.type = type;
    }

    public Location(String name, LocationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public Location(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    @Override
    public String toString() {
        return "Location| " +
                "name='" + name + '\'' +
                ", type=" + type +
                ", coodonates : x=" + x +
                ", y=" + y;
    }
}
