package Day03_If_Switch_Loop;

import java.util.Scanner;

public class BTVN_5 {
// BÀI 5:
// Viết chương trình để đảo ngược một xâu ký tự nhập vào từ bàn phím.

// Ví dụ:
// Input a string: techmaster hoc la co viec
// Reverse string: ceiv oc al coh retsamhcet
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a string:\n\t");
        String text = input.nextLine();
        input.close();

        System.out.print("Reverse string:\n\t");
        for (int i = text.length()-1; i>=0; --i) {
            System.out.print(text.charAt(i));
        }
    }
}