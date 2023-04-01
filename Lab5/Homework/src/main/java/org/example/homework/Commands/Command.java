package org.example.homework.Commands;

import org.example.homework.Catalog.Catalog;
import org.example.homework.Exceptions.CommandException;
import org.example.homework.Exceptions.CustomException;

public interface Command {

    void implementCommand() throws CommandException;

}
