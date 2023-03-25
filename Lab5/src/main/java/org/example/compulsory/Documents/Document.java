package org.example.compulsory.Documents;

import java.io.Serializable;
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
    private String location;
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
    public Document(String title, String id, String location, DocumentType type) {
        this.title = title;
        this.id = id;
        this.location = location;
        this.type = type;
    }

    /**
     * constructor pt homework, primeste in plus o lista de taguri
     */
    public Document(String title, String id, String location, Map<String, Object> tags, DocumentType type) {
        this.id = id;
        this.title = title;
        this.location = location;
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

    public void setLocation(String location) {
        this.location = location;
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

    public String getLocation() {
        return location;
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
                ", location='" + location + '\'' +
                ", type=" + type;
    }
}
