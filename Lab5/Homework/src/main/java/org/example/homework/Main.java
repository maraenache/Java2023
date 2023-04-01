package org.example.homework;

import org.example.homework.Catalog.*;
import org.example.homework.Commands.*;
import org.example.homework.Document.*;
import org.example.homework.Exceptions.*;
import org.xml.sax.SAXException;

import java.io.IOException;

public class Main {
    /***
     * Aplicatia din main creeaza un catalog, apoi ii transforma continutul in memorie
     * prin functia save(deserializarea obiectului catalog), si dupa il incarca inapoi in fisier (fac write,deserializarea) informatiile vor ajunge in fisier,
     * suprascriind continutul initial al fisierului
     */
    public static void main(String args[]) throws IOException, InvalidCatalogException, CustomException, SAXException, CommandException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws IOException, InvalidCatalogException, CustomException, SAXException, CommandException {
        Catalog catalog = new Catalog("My Catalog");

        Document book = null;
        try {
            book = new Book("IndigoEyes", "ID3", "E:\\indigoEyes.pdf");
        } catch (InvalidCatalogException e) {
            System.out.println(e.getMessage());
        }
        CommandUtil addComand = new AddCommand(catalog, book);
        addComand.implementCommand();
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

        Command viewBookCommand = new ViewCommand(article);//article.open();
        viewBookCommand.implementCommand();

        CommandUtil reportCommand = new ReportFCommand(catalog, "E:\\report.html");
        reportCommand.implementCommand();

        CommandUtil listCommand = new ListCommand(catalog);
        listCommand.implementCommand();

        try {
            CatalogUtil.save(catalog, "E:\\java\\catalog.json");
        } catch (IOException e) {
            System.err.println("Error saving catalog: " + e.getMessage());
        }
    }

    private void testLoadView() throws InvalidCatalogException, IOException {
        Catalog catalogAfterDeserialization = CatalogUtil.load("E:\\java\\catalog.json");
        System.out.println("The catalog obtained after deserialization\n" + catalogAfterDeserialization);
        CatalogUtil.view(catalogAfterDeserialization.findById("ID1"));
    }
}
/*
File->Project Structure->artifact->+->creat jar
Buid->Build Artifacts
Terminal:cd unde am fisierul executabil jar si rulez
Ult subpunctPS C:\Users\Mara\Desktop\tema\Lab5\out> cd artifacts
PS C:\Users\Mara\Desktop\tema\Lab5\out\artifacts> cd homework_jar
PS C:\Users\Mara\Desktop\tema\Lab5\out\artifacts\homework_jar> java -jar homework.jar
(Command List) The documents:
IndigoEyes
articol
todo
The catalog obtained after deserialization
Catalog| My Catalog
Documents
[
Document|id='ID3', title='IndigoEyes', location='E:\indigoEyes.pdf', type=BOOK,
Document|id='ID2', title='articol', location='E:\articol.pdf', type=ARTICLE,
Document|id='ID1', title='todo', location='C:\Users\Mara\Desktop\todo.txt', type=NOTE]
+se deschid documentele todo, articolul,si raportul, ca in img atasata

PS C:\Users\Mara\Desktop\tema\Lab5\out\artifacts\homework_jar>


 */