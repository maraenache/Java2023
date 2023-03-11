package lab2.homework;

import java.util.Objects;

public abstract class Location {
    protected String name;
    protected String type;
    protected double x, y;

    public Location() {
    }

    public Location(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Location(String name, String type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getType() {return type;}

    public void setName(String name) {
        this.name = name;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    /**
     * Returneaza o reprezentare sub forma unui string a unui obiect de tip Location.
     * Locatia va include numele, tipul si coordonatele instantei.
     * @return a string representation of the Location object
     */
    @Override
    public String toString() {
        return "\n" + "Location| " +
                "name= " + name + ", type " + type +
                ", coordinates : x=" + x +
                ", y=" + y;
    }

    /**
     * Compara Locatia cu alta obiect trimis ca parametru.
     * Rezultatul este true daca obiectul trimis ca parametru(nu e null) si  este o instanta a clasei Location
     * si are acelasi nume cu obiectul Location specificat de this. Fals, in caz contrar
     * Initial, am pus la return name.equals(location.name)&&(type.equals(location.type) && (x == location.getX() && y == location.getY()));
     * pentru a compara locatiile si din punct de vedere al coordonatelor. Dar am lasat doar nume, pentru a nu putea adauga 2 locatii cu acelasi nume,
     * daca adaug 2 locatii cu aceleasi coordonate si nume diferit, se va adauga in instanta problemei, dar va fi precizata ca este invalida
     * @param obj -obiectul pe care il comparam
     * @return true if the locations are equal, false otherwise
     *
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Location)) return false;
        Location location = (Location) obj;
        return name.equals(location.name);
    }
}
