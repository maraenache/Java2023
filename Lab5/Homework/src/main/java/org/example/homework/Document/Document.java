package org.example.homework.Document;

import org.example.homework.Exceptions.InvalidCatalogException;
import org.xml.sax.SAXException;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Document implements Serializable {
    /**
     * ID ul documentului
     **/
    private String id;
    /**
     * numele documentului
     */
    private String title;
    /**
     * calea documentului
     **/
    private String path;
    /**
     * pt homework, o alternativa a tagurilor XML, ex pt String data la care a fost facut documentul, pt Object punem Date
     * sau numele autorului  si String
     */
    private Map<String, Object> tags = new HashMap<>();

    /**
     * tipul documentului, acesta poate fi BOOK, ARTICLE, NOTE(enum)
     */
    private DocumentType type;

    /**
     * constructor Default necesar pentru serializare
     */
    public Document() {
        //default constructor
    }

    /**
     * constructor ce primeste ca parametri un nume, un id, o locatie si un timp
     * si creeaza un obiect de tip document
     */
    public Document(String title, String id, String path, DocumentType type) throws InvalidCatalogException {
        if (!new File(path).exists())
            throw new InvalidCatalogException("Calea " + path + " este invalida");
        this.title = title;
        this.id = id;
        this.path = path;
        this.type = type;
    }

    /**
     * constructor pt homework, primeste in plus o lista de taguri
     */
    public Document(String title, String id, String path, Map<String, Object> tags, DocumentType type) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.tags = tags;
        this.type = type;
    }

    //seteri si getteri
    public void setId(String id) {

        this.id = id;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public void setLocation(String path) {

        this.path = path;
    }

    public void setTags(Map<String, Object> tags) {

        this.tags = tags;
    }

    public DocumentType getType() {

        return type;
    }

    public void setType(DocumentType type) {

        this.type = type;
    }

    public String getId() {

        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    /**
     * Adauga in hasmapul tagurilor un tag de forma <nume, tip>
     *
     * @param key-numele tagului, ex autor
     * @param obj-obiect care sa implementeze cheia, ex String
     */
    public void addTag(String key, Object obj) {

        tags.put(key, obj);
    }

    @Override
    public String toString() {
        return "\nDocument|" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + path + '\'' +
                ", type=" + type;
    }

    /**
     * am folosit clasa Desktop pentru a deschide documentul de la locatia path
     *
     * @throws IOException
     */
    public void open() throws IOException {
        Desktop.getDesktop().open(new File(path));
    }
}