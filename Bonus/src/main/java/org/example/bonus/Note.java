package org.example.bonus;


public class Note extends Document {
    public Note(String title, String id, String location) throws InvalidCatalogException {

        super(title, id, location, DocumentType.NOTE);
    }

    public Note() {
    }
}
