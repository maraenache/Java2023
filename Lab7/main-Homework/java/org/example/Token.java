package org.example;

public class Token {

    private final int number; //final- valoare nu poate fi schimbata

    public Token(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}