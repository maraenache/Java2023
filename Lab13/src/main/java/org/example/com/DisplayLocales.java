package org.example.com;

import java.util.Locale;

public class DisplayLocales implements Command{
    public void execute() {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            System.out.println(locale.toString());
        }
    }
}