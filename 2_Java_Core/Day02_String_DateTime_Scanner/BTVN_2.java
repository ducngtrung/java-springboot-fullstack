import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class BTVN_2 {
// Viết chương trình đọc từ bàn phím các biến số của một cuộc thi chạy: Quãng đường, Thời gian bắt đầu, Thời gian kết thúc.
// Tính thời gian chạy và vận tốc trung bình.
    public static void main(String[] args) {
        double distance = 0.0;
        String startTimeStr = "";
        String finishTimeStr = "";
        Scanner scanner = new Scanner(System.in);

        // Nhập khoảng cách từ bàn phím dưới dạng số thập phân, gán vào biến distance
        System.out.print("Nhập quãng đường chạy (km): ");
        distance = scanner.nextDouble();
        scanner.nextLine();
        
        // Nhập thời gian bắt đầu, gán vào biến startTimeStr
        System.out.print("Nhập thời gian bắt đầu (H:mm): ");
        startTimeStr = scanner.nextLine();
        
        // Nhập thời gian kết thúc, gán vào biến finishTimeStr
        System.out.print("Nhập thời gian kết thúc (H:mm): ");
        finishTimeStr = scanner.nextLine();

        scanner.close();
        
        DateTimeFormatter timeformat = DateTimeFormatter.ofPattern("H:mm");
        // Chuyển startTimeStr và finishTimeStr sang kiểu LocalDateTime
        LocalTime startTime = LocalTime.parse(startTimeStr, timeformat);
        LocalTime finishTime = LocalTime.parse(finishTimeStr, timeformat);
        
        Duration duration = Duration.between(startTime, finishTime);
        // Tính và in ra thời gian chạy
        System.out.printf("Thời gian chạy: %s phút\n", duration.toMinutes());
        // Tính và in ra vận tốc trung bình (km/h)
        System.out.printf("Vận tốc trung bình: %s km/h\n", distance/(duration.toMinutes())*60);
    }
}