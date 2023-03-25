package org.example.compulsory.Exceptions;

/**
 * Exceptie customizata, folosind Decorator Pattern
 * folosita in functia load, si poate aparea in cazul in care
 * operatia read nu functioneaza, sau daca calea nu trimite spre locul
 * unde a fost obtinut fisierul serializat de functia save
 */
public class InvalidCatalogException extends Exception {
    public InvalidCatalogException(String exc) {
        super(exc);
    }
}
