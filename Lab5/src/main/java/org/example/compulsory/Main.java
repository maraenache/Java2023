package org.example.compulsory;

import org.example.compulsory.Catalog.Catalog;
import org.example.compulsory.Catalog.CatalogUtil;
import org.example.compulsory.Documents.Article;
import org.example.compulsory.Documents.Book;
import org.example.compulsory.Documents.Document;
import org.example.compulsory.Documents.Note;
import org.example.compulsory.Exceptions.InvalidCatalogException;

import java.io.IOException;

public class Main {
    /***
     * Aplicatia din main  creeaza un catalog, apoi ii transforma continutul in memorie
     * prin functia save(deserializarea obiectului catalog), si dupa il incarca inapoi in fisier (fac write,deserializarea) informatiile vor ajunge in fisier,
     * suprascriind continutul initial al fisierului
     */
    public static void main(String args[]) throws IOException, InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");

        Document doc1 = new Note("todo", "ID1", "C:\\Users\\Mara\\Desktop\\todo.txt");
        Document doc2 = new Article("articol", "ID2", "E:\\articol");
        Document doc3 = new Book("IndigoEyes", "ID3", "E:\\indigoEyes");

        catalog.add(doc1);
        catalog.add(doc2);
        catalog.add(doc3);

        try {
            CatalogUtil.save(catalog, "E:\\java\\catalog.json");
        } catch (IOException e) {
            System.err.println("Error saving catalog: " + e.getMessage());
        }

    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalogAfterDeserialization = CatalogUtil.load("E:\\java\\catalog.json");
        System.out.println("The catalog obtained after deserialization\n" + catalogAfterDeserialization);
        CatalogUtil.view(catalogAfterDeserialization.findById("ID1"));
    }
}
/*
OUTPUT:
The catalog obtained after deserialization
Catalog| MyDocuments
Documents
[
Document|id='ID1', title='todo', location='C:\Users\Mara\Desktop\todo.txt', type=NOTE,
Document|id='ID2', title='articol', location='E:\articol', type=NOTE,
Document|id='ID3', title='IndigoEyes', location='E:\indigoEyes', type=BOOK]

View document with ID ID1
ID: ID1
Title: todo
Location: C:\Users\Mara\Desktop\todo.txt
Type: NOTE

 */