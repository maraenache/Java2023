package org.example.bonus;

public class Article extends Document {
    public Article(String title, String id, String location) throws InvalidCatalogException {

        super(title, id, location, DocumentType.ARTICLE);
    }

    public Article() {
    }
}