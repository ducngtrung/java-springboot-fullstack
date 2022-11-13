package util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimeUtil {
    
    // Khai báo date formatter dạng dd/MM/yyyy
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    /*
     * convert from dd/MM/yyyy to LocalDate
     * @param date string
     * @return LocalDate
     */
    public static LocalDate convertStringToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, formatter);
    }

    /*
     * convert from LocalDate to dd/MM/yyyy
     * @param LocalDate
     * @return date string
     */
    public static String convertLocalDateToString(LocalDate date) {
        return date.format(formatter);
    }
}