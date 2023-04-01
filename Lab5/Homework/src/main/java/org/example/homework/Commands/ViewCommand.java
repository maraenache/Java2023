package org.example.homework.Commands;

import org.example.homework.Exceptions.CommandException;
import org.example.homework.Exceptions.CustomException;
import org.example.homework.Document.Document;

import java.io.IOException;

/**
 * clasa ViewCommand extinde interfata Command,
 * si se ocupa cu adaugarea unui document in catalog
 */
public class ViewCommand implements Command {
    Document document;

    /**
     * @param document-documentul ce urmeaza deschis
     */
    public ViewCommand(Document document) {

        this.document = document;
    }

    /**
     * metoda deschide documentul specificat din catalog,
     * iar in caz ca aceasta operatie nu este posibila
     * arunca o exceptie customizata
     */
    @Override
    public void implementCommand() throws CommandException {
        try {
            document.open();
        } catch (IOException e) {
            throw new CommandException("The view Command failed" + e.getMessage());
        }
    }
}
