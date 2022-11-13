import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Date_Time {
    public static void main(String[] args) {
        // Ngày giờ hiện tại
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Ngày giờ hiện tại: " + currentDateTime);

        // Hiển thị giờ tùy chọn
        LocalTime time = LocalTime.of(9, 45, 23);
        System.out.println("Time: " + time);
        
        // Tính tuối
        LocalDate birthday = LocalDate.of(1994, 4, 29);
        LocalDate currentDate = LocalDate.now();
        int birthdayYear = birthday.getYear();
        int currentYear = currentDate.getYear();
        int age = currentYear - birthdayYear;
        System.out.println("Tuổi của tôi: " + age);
            // Cách 2: int age = Period.between(birthday, currentDate).getYears();


        // Cộng ngày
        LocalDate newDate = currentDate.plusDays(12);
        System.out.println("Cộng thêm 12 ngày từ ngày hiện tại: " + newDate);

        // Kiểm tra năm nhuận
        System.out.println("Năm nay có phải năm nhuận không? " + currentDate.isLeapYear());

        // So sánh date
        boolean compareDate = currentDate.isAfter(birthday);
        System.out.println("Ngày hiện tại có sau ngày sinh nhật không? " + compareDate);

        // Hiển thị ngày giờ theo định dạng mới
        DateTimeFormatter newformat = DateTimeFormatter.ofPattern("E dd/MM/yyyy hh:mm:ss.SS a");
        String currentDateTime_formatted = currentDateTime.format(newformat);
        System.out.println("Ngày giờ hiện tại (formatted): " + currentDateTime_formatted);

        // Tính khoảng thời gian giữa 2 mốc
        LocalDateTime pastTime = LocalDateTime.parse("31/08/2022 12:56:30", formatter);
        LocalDateTime currentTime = LocalDateTime.now();
        Duration duration = Duration.between(pastTime, currentTime);
        System.out.println("pastTime: " + pastTime);
        System.out.println("currentTime: " + currentTime);
        System.out.println("duration: " + duration.toHours() + " hours");
        
        LocalDateTime pastTime1 = stringToDateTime("31/08/2022 12:56:30");
        Duration duration1 = Duration.between(pastTime1, currentTime);
        System.out.println("pastTime1: " + pastTime1);
        System.out.println("currentTime: " + currentTime);
        System.out.println("duration1: " + duration1.toHours() + " hours");
    }
    
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    
    static LocalDateTime stringToDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, formatter);
    }
}