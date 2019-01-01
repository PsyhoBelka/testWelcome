package ua.rozhkov;

import org.testng.annotations.Test;

import java.io.UnsupportedEncodingException;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static org.testng.Assert.assertEquals;

public class DayTimeWelcomeTest {
    private DayTimeWelcome dayTimeWelcome = new DayTimeWelcome();
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("Greetings");

    @Test
    public void testShowWelcome() throws UnsupportedEncodingException {
        if (LocalTime.now().isAfter(LocalTime.of(6, 0)) && LocalTime.now().isBefore(LocalTime.of(8, 59, 59))) {
            assertEquals(dayTimeWelcome.showWelcome(), new String(resourceBundle.getString("good_morning").getBytes("ISO-8859-1"), "windows-1251"));
        }
        if (LocalTime.now().isAfter(LocalTime.of(9, 0)) && LocalTime.now().isBefore(LocalTime.of(18, 59, 59))) {
            assertEquals(dayTimeWelcome.showWelcome(), new String(resourceBundle.getString("good_day").getBytes("ISO-8859-1"), "windows-1251"));
        }
        if (LocalTime.now().isAfter(LocalTime.of(19, 0)) && LocalTime.now().isBefore(LocalTime.of(22, 59, 59))) {
            assertEquals(dayTimeWelcome.showWelcome(), new String(resourceBundle.getString("good_evening").getBytes("ISO-8859-1"), "windows-1251"));
        }
        if (LocalTime.now().isAfter(LocalTime.of(23, 0)) && LocalTime.now().isBefore(LocalTime.of(5, 59, 59))) {
            assertEquals(dayTimeWelcome.showWelcome(), new String(resourceBundle.getString("good_night").getBytes("ISO-8859-1"), "windows-1251"));
        }
    }
}