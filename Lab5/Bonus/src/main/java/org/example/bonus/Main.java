package org.example.bonus;

import org.apache.tika.exception.TikaException;
import org.graph4j.*;
import org.graph4j.alg.coloring.GreedyColoring;
import org.graph4j.alg.coloring.VertexColoring;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {

    static Catalog catalog = new Catalog();
    private Graph graph;
    private int numDocuments = 13;
    private int numberOfColors;


    public static void main(String args[]) throws IOException, InvalidCatalogException, CustomException, TikaException, SAXException, org.xml.sax.SAXException {
        Main app = new Main();
        app.createModel();
        app.createGraph();
        app.solveProblem();
        app.color();
    }

    private void color()
    {
        catalog.colorDocuments(catalog.getDocuments());

    }
    private void createModel() throws IOException, InvalidCatalogException, CustomException, TikaException, SAXException, org.xml.sax.SAXException {
        Catalog catalog = new Catalog("My Catalog");

        Document book = null;
        try {
            book = new Book("IndigoEyes", "ID3", "E:\\indigoEyes.pdf");
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
        catalog.add(book);

        Document article = null;
        try {
            article = new Article("articol", "ID2", "E:\\articol.pdf");
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
        catalog.add(article);

        Document note = null;
        try {
            note = new Note("todo", "ID1", "C:\\Users\\Mara\\Desktop\\todo.txt");
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
        catalog.add(note);

        Document bookM1 = new Book("Book1", "B1", "C:\\Users\\Mara\\Desktop\\fac\\JAVA\\Lab5\\bookMetad.docx");
        bookM1.info();
        catalog.add(bookM1);

        Document bookM2 = new Book("Book2", "B2", "C:\\Users\\Mara\\Desktop\\fac\\JAVA\\Lab5\\bookMetadnuex.docx");
        bookM2.info();
        catalog.add(bookM2);
        System.out.println(catalog.areRelated(bookM1, bookM2));


        //System.out.println("doc de 0"+catalog.getDocument(0));
        // Generate large instances of documents
        for (int i = 1; i <= numDocuments; i++) {
            String name = "Document" + i;
            String id = "N" + i;
            String path = "C:\\Users\\Mara\\Desktop\\fac\\JAVA\\Lab5\\document" + i + ".txt";
            Document document = new Note(name, id, path);
            document.info();
            catalog.add(document);
        }

        //System.out.println(catalog.areRelated(catalog.findById("ID1"), catalog.findById("ID2")));

        Command listCommand = new ListCommand(catalog);
        listCommand.implementCommand();
        this.catalog=catalog;
        System.out.println(catalog.getNumberOfDocuments());
        numDocuments= catalog.getNumberOfDocuments();
    }
    private void createGraph() {
        System.out.println(catalog.getNumberOfDocuments());

        this.graph = GraphBuilder.empty()
                .estimatedNumVertices(numDocuments)
                .buildGraph();

        for (Document doc : catalog.getDocuments()) {
            graph.addVertex(doc.getId());
        }

        for (int i = 0; i < numDocuments; i++) {
            Document doc1 = catalog.getDocument(i);
            for (int j = i + 1; j < numDocuments; j++) {
                Document doc2 = catalog.getDocument(j);
                if (catalog.areRelated(doc1, doc2)) {
                    graph.addEdge(doc1.getId(), doc2.getId());
                }
            }
        }
    }

    public int solveProblem() {
        VertexColoring coloring = new GreedyColoring(graph).findColoring();
        if (coloring != null) {
            int numColorsUsed = coloring.numUsedColors();
            System.out.println("The number of colors used: " + numColorsUsed);
            return numColorsUsed;
        }
        return -1;
    }
}
