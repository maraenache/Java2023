package lab3.compulsory;

public class Position {
    private String name;
    private double salary;
    private int yearsOfExperience;

    public Position(String name, double salary, int yearsOfExperience) {
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    @Override
    public String toString() {
        return "Position:" +
                "name='" + name + "'";
    }
}
