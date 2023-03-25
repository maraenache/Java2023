package org.example.homework;


import com.github.javafaker.Faker;

public class Project implements Comparable<Project> {

    /**
     * numele proiectului
     */
    String name;

    /**capacitatea- daca este 0, proiectul este luat, daca este 1, acesta inca este disponibil pentru un student*/
    int capacity;

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**constructorul default,
     * in cazul in care proiectul nu are nume, il generam folosind faker*/
    public Project()
    {
        name= new Faker().app().name();
        this.capacity=1;
    }

    /**
     * constructor ce primeste numele proiectului
     * creeaza un obiect de tip Project
     */
    public Project(String name) {

        this.name = name;
        this.capacity=1;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
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
