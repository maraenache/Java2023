package org.example.bonus;

public class Book extends Document {

    public Book(String title, String id, String location) throws InvalidCatalogException {

        super(title, id, location, DocumentType.BOOK);
    }

    public Book() {
    }
}