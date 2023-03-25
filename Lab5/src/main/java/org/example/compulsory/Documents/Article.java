package org.example.compulsory.Documents;

public class Article extends Document {
    public Article(String title, String id, String location) {

        super(title, id, location, DocumentType.NOTE);
    }

    public Article() {
    }
}
