package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeConverter {
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    // convert from dd/MM/yyyy HH:mm:ss to LocalDateTime
    public static LocalDateTime stringToDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, formatter);
    }

    // convert from LocalDateTime to dd/MM/yyyy HH:mm:ss
    public static String dateTimeToString(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }
}