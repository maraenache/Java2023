package lab3.homework;

import java.time.LocalDate;
import java.util.*;

public abstract class Person implements Node, Comparable<Person> {
    /**
     * Numele persoanei
     */
    private String name;
    /**
     * ID -ul persoanei
     */
    private int id;

    /**
     * Ziua de nastere
     */
    LocalDate birthday;

    /**
     * Compania pentru care lucreaza persoana
     */
    private Company company;
    private Map<Node, String> relationships = new HashMap<>();

    /**
     * constructor
     * Creeaza un obiect de tip Person avand un nume dat, ID-ul
     *
     * @param name numele persoanei
     * @param id   ID-ul persoanei
     **/
    public Person(String name, int id, LocalDate birthday) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
    }

    /**
     * constructor
     * Creeaza un obiect de tip Person avand un nume dat, ID-ul, compania si pozitia in care lucreaza.
     *
     * @param name    numele persoanei
     * @param id      ID-ul persoanei
     * @param company compania in care lucreaza
     **/
    public Person(String name, int id, LocalDate birthday, Company company) {
        this.name = name;
        this.id = id;
        this.company = company;
        this.birthday = birthday;
    }

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
     * Adauga un nou element de tip cheie-nodul, valoare-tipul de relatie in hasmapul relationships
     * @param node-persoana sau compania cu care are o relatie
     * @param value- tipul de relatie dintre this si node
     */
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    /**
     * override al metodei default getImportance din interfata Node
     * importanta unui nod este dat de numarul de conexiuni
     * cand aduagam o noua relatie, dimensiunea hashMapului creste cu 1,
     * deci daca returnam dimensiunea HashMapului, obtinem numarul de conexiuni
     */
    public int getImportance() {
        Map<Node, String> relationships1 = relationships;
        return relationships1.size();

    }

    /**
     * la afisarea persoanelor, la campul relationships am modificat putin afisare
     * inainte aveam return relationship, din getterul generat
     * dar asa se afisau toate detaliile pentru persoanele din relatie,
     * in schimb acum, am lasat doar numele si tipul relatiei, de ex pers1...,relationship:pers2->best-friend, pers3->coworkers
     *
     * @return
     */
    public String getRelationships() {
        StringBuilder sb = new StringBuilder();
        sb.append("-");
        for (Node node : relationships.keySet()) {
            sb.append(node.getName()).append("->").append(relationships.get(node)).append("; ");
        }
        return sb.toString();
    }

    public void setRelationships(Map<Node, String> relationships) {
        this.relationships = relationships;
    }

    /**
     * getter
     * metoda ce returneaza ziua de nastere a persoanei
     *
     * @return un obiect de tip Localdate
     */
    public LocalDate getBirthday() {
        return birthday;
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
     * Stringul va include numele, id-ul, compania si pozitia
     *
     * @return un string, ce reprezinta un obiect de tip Person.
     */

    @Override
    public String toString() {
        return "Person| " +
                "name='" + name + '\'' +
                ", id=" + id +
                ", company= " + company.getName() + ", " +
                ", relationships=" + relationships +
                '}';
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
/*
* @Override
public int compareTo(Person other) {
    return Comparator.comparing(Person::getName, Comparator.nullsFirst(String::compareTo)).compare(this, other);
}
 sau
 * ...
Collections.sort(nodeList, Comparator.comparing(Node::getName));
*/
