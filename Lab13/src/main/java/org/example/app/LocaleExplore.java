package org.example.app;

import org.example.com.DisplayLocales;
import org.example.com.Info;
import org.example.com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {

    private static ResourceBundle messages;

    //seteaza setul de resurse potrivit limbii curente
    public static void setMessages(Locale locale){
        messages = ResourceBundle.getBundle("res.Messages", locale);
    }

    /** "ro_RO", cauta fișierul "Messages_ro.properties" din directorul res,
     *  implicit este "en_US", "Messages_en_US.properties"

     */
    public static void main(String[] args) {
        LocaleExplore.setMessages(Locale.getDefault());

        Scanner scanner = new Scanner(System.in);
        String command = "";

        while(!command.equals("exit")){
            System.out.println(LocaleExplore.messages.getString("prompt"));
            command = scanner.nextLine();

            if(command.equals("exit")){
                break;
            }

            else if(command.equals("locales")){
                System.out.println(LocaleExplore.messages.getString("locales"));
                DisplayLocales displayLocales = new DisplayLocales();
                displayLocales.execute();
            }

            else if(command.equals("locale.set")){
                SetLocale setLocale = new SetLocale();
                setLocale.execute();
                LocaleExplore.setMessages(Locale.getDefault());
            }

            else if(command.equals("info")){
                Info info = new Info();
                info.execute();
            }

            else if(command.startsWith("info ")){
                System.out.println(LocaleExplore.messages.getString("info"));
                String[] commandParts = command.split(" ");
                System.out.println(commandParts[1]);
                String localeString = commandParts[1];
                String[] localeParts = localeString.split("_");

                if(localeParts.length==1){
                    Locale.setDefault(new Locale(localeParts[0]));
                }
                else{
                    Locale.setDefault(new Locale(localeParts[0], localeParts[1]));
                }
                Info info = new Info();
                info.execute();

               // Locale locale = Locale.forLanguageTag(commandParts[1]);

            }
        else{
                System.out.println(LocaleExplore.messages.getString("invalid"));
            }
        }
    }
}