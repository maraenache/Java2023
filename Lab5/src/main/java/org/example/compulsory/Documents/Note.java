package org.example.compulsory.Documents;

public class Note extends Document {
    public Note(String title, String id, String location) {

        super(title, id, location, DocumentType.NOTE);
    }

    public Note() {
    }
}
