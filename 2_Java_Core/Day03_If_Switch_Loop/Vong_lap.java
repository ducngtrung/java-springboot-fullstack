package Day03_If_Switch_Loop;

import java.util.Scanner;

public class Vong_lap {
    public static void main(String[] args) {
        // In ra 10 vòng lặp
        for (int index = 1; index <= 10; ++index) {
            System.out.println("Vòng lặp thứ " + index);
        }

        // Dùng vòng lặp for để in ra từng ký tự trong xâu ký tự
        String text = "Toi la coder";
        for (int index = 0; index < text.length(); ++index) {
            System.out.printf("Ký tự ở vị trí %d: %s\n", index, text.charAt(index));
        }

        // Tìm vị trí các nguyên âm và đếm số lần ký tự 'o' xuất hiện trong xâu ký tự
        int count = 0;
        for (int index = 0; index < text.length(); ++index) {
            char character = text.charAt(index);
            switch (character) {
                case 'u':
                case 'e':
                case 'o':
                case 'a':
                case 'i': {
                    System.out.println("Nguyên âm " + character + " xuất hiện ở vị trí " + index);
                    break;
                }
            }
            if (character == 'o') {
                ++count;
            }
        }
        System.out.println("Số ký tự o: " + count);

        // Dùng vòng lặp while để in ra từng ký tự trong xâu ký tự
        int index = text.length()-1;
        while (index >= 0) {
            int position = text.length()-1-index;
            System.out.printf("Ký tự ở vị trí %d: %s\n", position, text.charAt(position));
            --index;
        }

        // Dùng vòng lặp do-while để in ra từng ký tự trong xâu ký tự
        index = 0;
        do {
            System.out.printf("Ký tự ở vị trí %d: %s\n", index, text.charAt(index));
            ++index;
        } while (index < text.length());

        // Dùng vòng lặp do-while để yêu cầu người dùng nhập một số nguyên bất kỳ từ bàn phím, chỉ dừng lại khi nào người dùng nhập một số chẵn
        Scanner input = new Scanner(System.in);
        boolean isEven = false;
        do {
            System.out.print("Nhập một số nguyên bất kỳ: ");
            int inputNumber = input.nextInt();
            if (inputNumber%2 == 0) {
                System.out.println("Bạn vừa nhập số chẵn");
                isEven = true;
            }
        } while (isEven == false);
        input.close();

        // Dùng từ khóa break để tìm vị trí ký tự 'o' đầu tiên trong xâu ký tự
        for (int i = 0; i < text.length(); ++i) {
            char character = text.charAt(i);
            if (character == 'o') {
                System.out.println("Ký tự 'o' đầu tiên ở vị trí " + i);
                break;
            }
        }

        // Dùng từ khóa continue để in ra tất cả các ký tự khác 'o' trong xâu ký tự
        int j = 0;
        System.out.println("In ra các ký tự khác 'o':");
        while (j < text.length()) {
            char character = text.charAt(j);
            if (character == 'o') {
                ++j;
                continue;
            }
            System.out.println(character);
            ++j;
        }
    }
}