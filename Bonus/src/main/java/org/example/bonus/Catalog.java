package org.example.bonus;


import java.io.Serializable;
import java.util.*;

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

    public boolean areRelated(Document doc1, Document doc2) {
        for (String tag : doc1.getTags().keySet()) {
            if (doc2.getTags().containsKey(tag)) {
                return true;
            }
        }
        return false;
    }
    public void colorDocuments(List<Document> documents) {
        // initialize the colors array
        int[] colors = new int[documents.size()];
        Arrays.fill(colors, -1);

        // color the first vertex with color 0
        colors[0] = 0;

        // iterate over the remaining vertices
        for (int i = 1; i < documents.size(); i++) {
            Document doc = documents.get(i);

            // initialize the available colors set
            Set<Integer> availableColors = new HashSet<>();
            for (int j = 0; j < i; j++) {
                if (areRelated(doc, documents.get(j))) {
                    availableColors.add(colors[j]);
                }
            }

            // choose the smallest available color
            int color = 0;
            while (availableColors.contains(color)) {
                color++;
            }

            colors[i] = color;
        }

        // print the results
        for (int i = 0; i < documents.size(); i++) {
            System.out.println(documents.get(i) + " color: " + colors[i]);
        }
    }
    /**
     * Adauga documentul doc in lista documents
     *
     * @param doc-documentul pe care dorim sa l adaugam in lista
     */
    public void add(Document doc) {

        documents.add(doc);
    }
    public int getNumberOfDocuments()
    {
        return documents.size();
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

    public Document getDocument(int i) {
        return documents.get(i);
    }
}