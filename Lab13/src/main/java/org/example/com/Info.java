package org.example.com;


import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

public class Info implements Command{
    private Locale locale;

    public Info(){
        this.locale = Locale.getDefault();
    }

    public Info(Locale locale){
        this.locale = locale;
    }

    public void setLocale(Locale locale){
        this.locale = locale;
    }

    public void execute() {
        System.out.println("Country: " + this.locale.getDisplayCountry());
        System.out.println("Language: " + this.locale.getDisplayLanguage());
        System.out.println("Currency: " + Currency.getInstance(this.locale).getCurrencyCode() + " (" + Currency.getInstance(this.locale).getDisplayName() + ")");
        DateFormatSymbols dateFormatSymbols = new DateFormatSymbols(this.locale);
        System.out.print("Week Days: ");
        for (String day : dateFormatSymbols.getWeekdays()) {
            if(day.length()!=0)
                System.out.print(day + ", ");
        }
        System.out.println();
        System.out.print("Months: ");
        for (String month : dateFormatSymbols.getMonths()) {
            if(month.length()!=0)
                System.out.print(month + ", ");
        }
        System.out.println();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", this.locale);
        System.out.println("Today: " + dateFormat.format(new Date()));
    }
}