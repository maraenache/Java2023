package lab3.bonus;

import java.time.LocalDate;

public class Programmer extends Person {
    int numberOfProjects;

    public Programmer(String name, int id, LocalDate birthday, int numberOfProjects) {
        super(name, id, birthday);
        this.numberOfProjects = numberOfProjects;
    }

    public int getNumberOfProjects() {
        return numberOfProjects;
    }

    @Override
    public String toString() {
        return "Programmer | Name: " + getName() + ", ID: " + getId() + ", Number of Projects: " + getNumberOfProjects() + ", Birthday: " + getBirthday() + ", relationships" +
                " " + getImportance() + " : " ;
    }
}
