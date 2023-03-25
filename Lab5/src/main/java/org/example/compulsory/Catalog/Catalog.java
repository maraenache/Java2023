package org.example.compulsory.Catalog;

import org.example.compulsory.Documents.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * contine un nume, o lista de documente si metode ce lucreaza doar la nivelul clasei (cum ar fi posibilitatea de a adauga
 * un nou document)
 */
public class Catalog implements Serializable {

    /**
     * numele catalogului
     */
    private String name;
    /**
     * Lista de documente din catalog(ce pot fi carti, articole, notite)
     */
    private List<Document> documents = new ArrayList<>();

    /**
     * constructor default necesar pentru serializare/deserializare
     **/
    public Catalog() {
        //default constructor
    }

    /**
     * constructor ce primeste numele unui document si creeaza un obiect de tipul Document
     *
     * @param name-nume pe care il dam documentului
     */
    public Catalog(String name) {
        this.name = name;
    }

    //setteri si getteri
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * Adauga documentul doc in lista documents
     *
     * @param doc-documentul pe care dorim sa l adaugam in lista
     */
    public void add(Document doc) {

        documents.add(doc);
    }

    /**
     * Identifica un obiect de tip Document cu ID ul primit ca parametru
     * Folosesc stream pentru a filtra doar obiectele ce au id ul egal cu parametrul
     * daca gasesc se returneaza, altfel null
     *
     * @param id-ID ul documentului pe care il cautam
     * @return-un obiect de tip Document cu ID ul id
     */
    public Document findById(String id) {
        return documents.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);

    }

    /**
     * @return o reprezentare in forma de sir a unui obiect de tip catalog ce contine numele catalogului si documentele incluse in acesta
     */
    public String toString() {
        return "Catalog| " + name + "\n" +
                "Documents\n" + documents;
    }
}