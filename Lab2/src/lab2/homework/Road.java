package lab2.homework;

public abstract class Road {
    protected String name;
    protected String type;
    protected int speedLimit;
    protected double length;
    Location start;
    Location end;

    public Road() {
    }

    public Road(String name, String type, Location start, Location end) {
        this.name = name;
        this.type = type;
        this.start = start;
        this.end = end;
    }

    public Road(String name, String type, Location start, Location end, int speedLimit, double length) {
        this.name = name;
        this.type = type;
        this.speedLimit = speedLimit;
        this.length = length;
        this.start = start;
        this.end = end;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setEnd(Location end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public double getLength() {
        return length;
    }

    public String getType() {
        return type;
    }

    /**
     * Un drum este format din 2 locatii, cea de inceput(start) si cea de sfarsit(end)
     * getterul getStart, returneaza un obiect de tip Location ce reprezinta locatia de inceput a drumului
     * @return-the start location of the Road
     */
    public Location getStart() {
        return start;
    }
    /**
     * getterul getEnd, returneaza un obiect de tip Location ce reprezinta locatia de sfarsit a drumului
     * @return-the finish location of the Road
     */

    public Location getEnd() {
        return end;
    }

    /**
     * Returneaza o reprezentare a unui obiect de tip Road sub forma unui string.
     * Locatia va include numele, limita de viteza, lungimea drumului si tipul sau.
     * @return a string representation of the Road object
     */
    @Override
    public String toString() {
        return "\n" + "Road " + name + "| " +
                "speedLimit=" + speedLimit +
                ", length=" + length +
                ", type=" + type;

    }

    /**
     * Compara obiectul Road din this cu alt obiect trimis ca parametru dupa nume.
     * Rezultatul este true daca obiectul trimis ca parametru(nu e null) si  este o instanta a clasei Road
     * si are acelasi nume cu obiectul Road specificat de this. Fals, in caz contrar
     *
     * @param obj -obiectul pe care il comparam
     * @return true if the roads name are the same, false otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Location)) {
            return false;
        }
        Road road = (Road) obj;
        return name.equals(road.name);
    }
}