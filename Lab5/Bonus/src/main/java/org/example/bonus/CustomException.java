package org.example.bonus;
public class CustomException extends Exception{
    public CustomException(String message, Exception cause)
    {

        System.out.println(message+cause);
    }
}

