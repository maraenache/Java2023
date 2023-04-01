package org.example.bonus;

public class ListCommand extends Command {
    Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void implementCommand() {
        System.out.println("The documents:");
        for (Document document : catalog.getDocuments()) {
            System.out.println(document.getId()+" "+document.getTitle()+" tags"+document.getTags());
        }
    }

}