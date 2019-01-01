package ua.rozhkov;

import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class TestWelcome {
    public static void main(String args[]) throws UnsupportedEncodingException {
        System.out.println("Welcome");
        Locale ru=new Locale("ru","RU");
        Locale en=new Locale("en","EN");
        DayTimeWelcome welcome=new DayTimeWelcome();

        Locale.setDefault(ru);
        System.out.println(welcome.getLocale());

        System.out.println(welcome.showWelcome());

    }
}
