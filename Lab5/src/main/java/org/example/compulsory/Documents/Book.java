package org.example.compulsory.Documents;

public class Book extends Document {

    public Book(String title, String id, String location) {

        super(title, id, location, DocumentType.BOOK);
    }

    public Book() {
    }
}
