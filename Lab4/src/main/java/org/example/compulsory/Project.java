package org.example.compulsory;

public class Project implements Comparable<Project> {
    /**
     * numele proiectului
     */
    String name;

    /**
     * constructor ce primeste numele proiectului
     * creeaza un obiect de tip Project
     */
    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * un string ce contine numele proiectului
     *
     * @return o reprezentare de tip String al unui obiect de tip Project
     */
    @Override
    public String toString() {
        return "Project|" +
                "name='" + name + '\'';
    }

    /**
     * override al functiei compareTo din interfata Comparable
     * compara 2 proiecte in functie de nume
     *
     * @param o proiectul cu care comparam
     * @return 0 daca numele proiectului din this este egal cu numele proiectului primit ca parametru
     * un numar negativ daca primul nume este "mai mic"(alfabetic inainte de cel de al doilea
     * un numar pozitiv daca primul nume este "mai mare"(alfabetic dupa de cel de al doilea
     */
    @Override
    public int compareTo(Project o) {
        return name.compareTo(o.getName());
    }
}
