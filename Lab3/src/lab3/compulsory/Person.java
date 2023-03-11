package lab3.compulsory;

import java.util.*;

public class Person implements Node, Comparable<Person> {
    /**
     * Numele persoanei
     */
    private String name;
    /**
     * ID -ul persoanei
     */
    private int id;
    /**
     * Compania pentru care lucreaza persoana
     */
    private Company company;
    /**
     * Pozitia pe care o are in companie
     */
    private Position position;
    /**
     * Multimea de colegi/ persoane cu care interactioneaza
     */
    private Set<Person> colleagues;

    /**
     * getter
     * override pentru metoda din interfata Node
     *
     * @return numele persoanei
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * getter
     * override pentru metoda din interfata Node
     *
     * @return ID-ul persoanei
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * constructor
     * Creeaza un obiect de tip Person avand un nume dat, ID-ul
     *
     * @param name numele persoanei
     * @param id   ID-ul persoanei
     **/
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * constructor
     * Creeaza un obiect de tip Person avand un nume dat, ID-ul, compania si pozitia in care lucreaza.
     *
     * @param name     numele persoanei
     * @param id       ID-ul persoanei
     * @param company  compania in care lucreaza
     * @param position pozitia pe care o are in companie
     **/
    public Person(String name, int id, Company company, Position position) {
        this.name = name;
        this.id = id;
        this.company = company;
        this.position = position;
    }

    /**
     * getter
     * metoda ce returneaza compania in care lucreaza persoana
     *
     * @return un obiect de tip Company
     */
    public Company getCompany() {
        return company;
    }

    /**
     * getter
     * metoda ce returneaza pozitia in care lucreaza persoana
     *
     * @return un obiect de tip Position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * setter
     * o metoda care seteaza numele persoanei
     *
     * @param name- numele persoanei
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter
     * o metoda care seteaza ID-ul
     *
     * @param id ID-ul persoanei
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * setter
     * o metoda ce seteaza compania unde lucreaza persoana
     *
     * @param company-compania in care lucreaza persoana
     */

    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     * setter
     * o metoda ce seteaza pozitia unde lucreaza persoana
     *
     * @param position-pozitia din companie
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Stringul va include numele, id-ul, compania si pozitia
     *
     * @return un string, ce reprezinta un obiect de tip Person.
     */
    @Override
    public String toString() {
        return "Person| " +
                "name='" + name + '\'' +
                ", id=" + id +
                ", company= " + company.getName() + ", " + position;
    }

    /**
     * o metoda care compara doua obiecte de tip Person in functie de nume.
     * Incerca sa compare numele celor doua persoane, returneaza zero daca sunt egale,
     * daca nu se pot compara sirurile si este vorba despre o exceptie de tip nullPointer
     * daca ambele siruri sunt nule, returneaza 0, daca cel din this este 0 returneaza -1,
     * iar daca cel din dreapta este null, returneaza 1
     *
     * @param other obiectul cu care comparam
     * @return -1 daca numele obiectului de tip Person this este "mai mic" decat numele obiectului other
     * zero daca numele obiectului de tip Person this este egal cu numele obiectului other
     * 1 daca numele obiectului de tip Person this este "mai mare" decat numele obiectului other
     */
    @Override
    public int compareTo(Person other) {
        try {
            return this.name.compareTo(other.name);
        } catch (NullPointerException e) {
            if (this.name == null && other.name == null) {
                return 0;
            } else if (this.name == null) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
