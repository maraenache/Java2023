package org.example.bonus;


public class AddCommand extends Command {
    private Catalog catalog;
    Document document;
    public AddCommand(Catalog catalog, Document document) {
        this.catalog = catalog;
        this.document=document;
    }

    public void implementCommand() throws CustomException {
        catalog.add(document);//catalog.getDocuments().add(document);
        System.out.println("Document added to catalog");
    }
}
