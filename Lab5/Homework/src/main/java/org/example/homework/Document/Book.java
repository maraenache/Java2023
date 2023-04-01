package org.example.homework.Document;

import org.example.homework.Exceptions.InvalidCatalogException;

public class Book extends Document {

    public Book(String title, String id, String location) throws InvalidCatalogException {

        super(title, id, location, DocumentType.BOOK);
    }

    public Book() {
    }
}
