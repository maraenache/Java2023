package lab3.homework;

import java.util.*;

public class Company implements Node, Comparable<Company> {
    /**
     * Numele companiei
     */
    private String name;
    /**
     * ID-ul companie
     */
    private int id;
    /**
     * Industria din care provine compania
     */
    private String industry;

    /**
     * getter override
     * override pentru metoda din interfata Node
     *
     * @return numele companiei
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * getter override
     * override pentru metoda din interfata Node
     *
     * @return ID-ul companiei
     */
    @Override
    public int getId() {
        return this.id;
    }

    /**
     * constructor
     * Creeaza un obiect de tip Company avand un nume dat, ID-ul
     *
     * @param name numele companiei
     * @param id   ID-ul companiei
     **/
    public Company(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * constructor
     * Creeaza un obiect de tip Company avand un nume dat, ID-ul si industria.
     *
     * @param name     numele companiei
     * @param id       ID-ul companiei
     * @param industry industria companei
     **/
    public Company(String name, int id, String industry) {
        this.name = name;
        this.id = id;
        this.industry = industry;
    }

    /**
     * setter
     * o metoda care seteaza numele companiei
     *
     * @param name-numele companiei
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter
     * o metoda care seteaza ID-ul
     *
     * @param id ID-ul companiei
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Stringul va include numele, id-ul, compania si industria
     *
     * @return un string, ce reprezinta un obiect de tip Company.
     */

    @Override
    public String toString() {
        return "Company|" + "name='" + name + '\'' + ", id=" + id + ", industry=" + industry;
    }

    /**
     * o metoda care compara doua obiecte de tip Company in functie de nume
     * incerca sa compare numele celor doua companii, returneaza zero daca sunt egale,
     * daca nu se pot compara sirurile si este vorba despre o exceptie de tip nullPointer
     * daca ambele siruri sunt nule, returneaza 0, daca cel din this este 0 returneaza -1,
     * iar daca cel din dreapta este null, returneaza 1
     *
     * @param other obiectul cu care comparam
     * @return -1 daca numele obiectului de tip Company this este "mai mic" decat numele obiectului other
     * zero daca numele obiectului de tip Company this este egal cu numele obiectului other
     * 1 daca numele obiectului de tip Company this este "mai mare" decat numele obiectului other
     */
    @Override
    public int compareTo(Company other) {
        try {
            return this.name.compareTo(other.getName());
        } catch (NullPointerException e) {
            if (this.name == null && other.getName() == null) {
                return 0;
            } else if (this.name == null) {
                return -1;
            } else {
                return 1;
            }
        }
    }

}
