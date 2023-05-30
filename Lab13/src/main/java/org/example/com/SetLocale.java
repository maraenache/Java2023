package org.example.com;

import java.util.Locale;
import java.util.Scanner;

public class SetLocale implements Command{
    public void execute() {
        System.out.println("Enter ");
        Scanner scanner = new Scanner(System.in);
        String localeString = scanner.nextLine();
        String[] localeParts = localeString.split("_");

        if(localeParts.length==1){
            Locale.setDefault(new Locale(localeParts[0]));
        }
        else{
            Locale.setDefault(new Locale(localeParts[0], localeParts[1]));
        }

        System.out.println("Locale set to " + Locale.getDefault());
    }
}