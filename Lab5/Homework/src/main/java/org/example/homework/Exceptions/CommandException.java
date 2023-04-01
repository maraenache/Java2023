package org.example.homework.Exceptions;

/**
 * o exceptie customizata, am aruncat o in cazurile in care o comanda(view,list,add) esueaza
 */
public class CommandException extends Exception {
    public CommandException(String message) {

        super(message);
    }
}