package org.example.homework.Commands;

import org.example.homework.Catalog.Catalog;
import org.example.homework.Document.Document;
import org.example.homework.Exceptions.CommandException;

/**
 * clasa ListCommand extinde clasa abstracta CommandUil,
 * si se ocupa cu adaugarea unui document in catalog
 */
public class ListCommand extends CommandUtil {

    public ListCommand(Catalog catalog) {

        super(catalog);
    }

    /**
     * metoda listeaza toate documentele din catalog,
     * iar in caz ca aceasta operatie nu este posibila
     * arunca o exceptie customizata
     */
    @Override
    public void implementCommand() throws CommandException {
        try {
            System.out.println("(Command List) The documents:");
            for (Document document : catalog.getDocuments()) {
                System.out.println(document.getTitle());
            }
        } catch (Exception e) {
            throw new CommandException("ListCommand failed: " + e.getMessage());
        }
    }
}