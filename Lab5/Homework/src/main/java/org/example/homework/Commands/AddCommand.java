package org.example.homework.Commands;

import org.example.homework.Catalog.Catalog;
import org.example.homework.Exceptions.CommandException;
import org.example.homework.Exceptions.CustomException;
import org.example.homework.Document.Document;
import org.example.homework.Exceptions.InvalidCatalogException;

import java.io.IOException;

/**
 * clasa AddCommand extinde clasa abstracta CommandUil,
 * si se ocupa cu adaugarea unui document in catalog
 */
public class AddCommand extends CommandUtil {
    Document document;

    /**
     * Constructorul primeste ca parametri un catalog si un document
     * @param catalog-catalogul unde dorim sa facem inserarea
     * @param document-documentul pe care il inseram
     */
    public AddCommand(Catalog catalog, Document document) {
        super(catalog);//constructorul clasei CommandUtil
        this.document = document;
    }

    /**
     * metoda adauga un cdocument in catalog,
     * iar in caz ca aceasta operatie nu este posibila
     * arunca o exceptie customizata
     */
    @Override
    public void implementCommand() throws CommandException {
        try {
            catalog.add(document);//catalog.getDocuments().add(document);
            System.out.println("Document added to catalog");
        } catch (Exception e) {
            throw new CommandException("AddCommand failed " + e.getMessage());
        }

    }
}

