package org.example.homework.Commands;

import org.example.homework.Catalog.Catalog;
import org.example.homework.Exceptions.CommandException;
import org.example.homework.Exceptions.CustomException;

public abstract class CommandUtil {
    protected Catalog catalog;

    public CommandUtil(Catalog catalog) {
        this.catalog = catalog;
    }

    public abstract void implementCommand() throws CommandException;

}
