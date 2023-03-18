package Day03_If_Switch_Loop;

import java.util.Scanner;

public class If_Else {
// Viết chương trình tính chỉ số BMI với cân nặng và chiều cao nhập từ bàn phím.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập cân nặng (kg): ");
        double can_nang = input.nextDouble();
        System.out.print("Nhập chiều cao (m): ");
        double chieu_cao = input.nextDouble();

        input.close();

        double BMI = can_nang / (Math.pow(chieu_cao, 2));
        System.out.println("Chỉ số BMI: " + BMI);

        if (BMI < 18.5) {
            System.out.print("Thiếu cân");
        } else if ((BMI >= 18.5) && (BMI <= 24.9)) {
            System.out.print("Cân đối");
        } else {
            System.out.print("Thừa cân");
        }
    }
}