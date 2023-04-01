package org.example.bonus;


import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.xml.sax.SAXException;

import java.awt.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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
       /* if( !new File(path).exists())
            throw new InvalidCatalogException("Calea " + path + " este invalida");*/
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
     * //daca nu exista calea, si nu poate extrage informatii din metadate, le generez random, pt a nu opri programul
     * @throws IOException
     * @throws TikaException
     * @throws SAXException
     */
    public void info() throws IOException, TikaException, SAXException {
        if (!new File(path).exists()) {  //throw new InvalidCatalogException("Calea " + path + " este invalida");
            // asigneaza un titlu random
            String[] titles = {"title1", "title2", "title3", "title4", "title5", "title6", "title7", "title8", "title9", "title10"};
            Random random = new Random();
            int randomIndex = random.nextInt(titles.length);

            // asigneaza unul din autorii de mai jos
            String[] authors = {"Mara", "Ana", "Ion", "Andrei", "Vlad"};
            randomIndex = random.nextInt(authors.length);

            //o val random dintre  2019 si  2023
            int randomYear = random.nextInt(4) + 2019;

            // o zi de la 1 la 30
            int randomDay = random.nextInt(30) + 1;
            tags.put("title", titles[randomIndex]);
            tags.put("author", authors[randomIndex]);
            tags.put("year", Integer.toString(randomYear));
            tags.put("day", Integer.toString(randomDay));
            System.out.println(tags);

        } else {
            System.out.println("Trying to extract metadata from " + getPath());
            Tika tika = new Tika();
            Metadata metadata = new Metadata();
            InputStream stream = new FileInputStream(new File(getPath()));
            try {
                tika.parse(stream, metadata);
            } catch (IOException e) {
                System.out.println("Cannot open file, assigning default tags.");
                return;
            }

            // Extrag din metadata titlu, autorul, anul si ziua
            String title = metadata.get("dc:title");
            String author = metadata.get("dc:creator");
            String year = metadata.get("dcterms:created").substring(0, 4);
            String day = metadata.get("dcterms:created").substring(8, 10);

            // adaug metadata in tags
            tags.put("title", title);
            tags.put("author", author);
            tags.put("year", year);
            tags.put("day", day);

            // System.out.println("Title: " + title);
            //System.out.println("Author: " + author);
            // System.out.println("Year: " + year);
            //System.out.println("Day: " + day);
            System.out.println(tags);
        }
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

    public void open() throws IOException {
        Desktop.getDesktop().open(new File(path));
    }

}