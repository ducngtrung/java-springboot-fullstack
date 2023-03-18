package Day03_If_Switch_Loop;

import java.util.Scanner;

public class Switch_Case {
// Viết chương trình nhập vào một tháng bất kỳ và in ra màn hình thông tin tháng đó có bao nhiêu ngày.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập tháng trong năm (1-12): ");
        int thang = input.nextInt();
        input.close();

        switch (thang) {
            case 2: {
                System.out.printf("Tháng %d có 28 hoặc 29 ngày", thang);
                break;
            }
            case 4:
            case 6:
            case 9:
            case 11: {
                System.out.printf("Tháng %d có 30 ngày", thang);
                break;
            }
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                System.out.printf("Tháng %d có 31 ngày", thang);
                break;
            }
            default: {
                System.out.println("Tháng không hợp lệ");
                break;
            }
        }
    }
}