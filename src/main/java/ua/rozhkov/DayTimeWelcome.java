package ua.rozhkov;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.Locale;
import java.util.ResourceBundle;

public class DayTimeWelcome {

    public Locale getLocale() {
        return Locale.getDefault();
    }

    public String showWelcome() throws UnsupportedEncodingException {
        String dayPart = getDayPart();
        ResourceBundle greetings = ResourceBundle.getBundle("Greetings");

        if (dayPart != null) {
            return new String(greetings.getString("good_" + dayPart).getBytes("ISO-8859-1"), "windows-1251");
        } else {
            throw new NullPointerException("Day part can't be null");
        }
    }

    private String getDayPart() {
        if (LocalTime.now().isAfter(LocalTime.of(6, 0)) && LocalTime.now().isBefore(LocalTime.of(8, 59,59))) {
            return "morning";
        }
        if (LocalTime.now().isAfter(LocalTime.of(9, 0)) && LocalTime.now().isBefore(LocalTime.of(18, 59,59))) {
            return "day";
        }
        if (LocalTime.now().isAfter(LocalTime.of(19, 0)) && LocalTime.now().isBefore(LocalTime.of(22, 59,59))) {
            return "evening";
        }
        if (LocalTime.now().isAfter(LocalTime.of(23, 0)) && LocalTime.now().isBefore(LocalTime.of(5, 59,59))) {
            return "night";
        }
        return null;
    }
}