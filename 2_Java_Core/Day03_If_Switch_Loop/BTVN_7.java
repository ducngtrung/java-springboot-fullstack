package Day03_If_Switch_Loop;

import java.util.Scanner;;

public class BTVN_7 {
// BÀI 7:
// Viết chương trình  để chuyển đổi giây thành giờ:phút:giây

// Ví dụ:
// Input a number of seconds: 86399
// 23:59:59
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a number of seconds: ");
        int inputSecs = input.nextInt();
        input.close();

        int Hours = inputSecs/3600;
        int Mins = (inputSecs - (3600*Hours))/60;
        int Secs = (inputSecs - 3600*Hours) - 60*Mins;

        if (Hours < 10) {
            System.out.print("0" + Hours + ":");
        } else {
            System.out.print(Hours + ":");
        }

        if (Mins < 10) {
            System.out.print("0" + Mins + ":");
        } else {
            System.out.print(Mins + ":");
        }

        if (Secs < 10) {
            System.out.print("0" + Secs);
        } else {
            System.out.print(Secs);
        }
    }
}