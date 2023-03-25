package org.example.homework;


import com.github.javafaker.Faker;

import java.util.List;

public class Student implements Comparable<Student> {
    /**
     * numele studentului
     */
    private String name;
    /**
     * lista de proiecte preferate de student
     */
    private List<Project> projects;

    /**
     * constructorul default,
     * in cazul in care studentul nu are nume, il generam folosind faker
     */

    public Student() {
        name = new Faker().name().firstName();
    }

    /**
     * constructor ce primeste numele studentului
     * creeaza un obiect de tip Student
     */
    public Student(String name) {

        this.name = name;
    }

    /**
     * constructor ce primeste numele studentului si lista de proiecte preferate
     * creeaza un obiect de tip Student
     */
    public Student(String name, List<Project> projects) {
        this.name = name;
        this.projects = projects;
    }

    public String getName() {

        return name;
    }

    /**
     * @return lista proiectelor preferate de student
     */
    public List<Project> getProjects() {

        return projects;
    }

    /**
     * Adauga un nou proiect in lista de proiecte
     *
     * @param project-proiectul pe care il adaug
     */
    public void addProject(Project project) {

        projects.add(project);
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    /**
     * un String ce contine numele si proiectele studentului
     *
     * @return o reprezentare de tip String al unui obiect de tip Project
     */
    @Override
    public String toString() {

        return getName();
    }

    /**
     * override al functiei compareTo din interfata Comparable
     * compara 2 studenti in functie de nume
     *
     * @param o studentul cu care comparam
     * @return 0 daca numele studentului din this este egal cu numele studentului o primit ca parametru
     * un numar negativ daca primul nume este "mai mic"(alfabetic inainte de cel de al doilea
     * un numar pozitiv daca primul nume este "mai mare"(alfabetic dupa de cel de al doilea
     */

    @Override
    public int compareTo(Student o) {

        return this.name.compareTo(o.getName());
    }
}