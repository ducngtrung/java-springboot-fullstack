package Day03_If_Switch_Loop;

import java.util.Scanner;

public class BTVN_6 {
// BÀI 6:
// Viết chương trình để viết hoa chữ cái đầu tiên của mỗi từ trong câu nhập vào từ bàn phím.

// Ví dụ:
// Input a sentence: hay viet hoa cac chu cai dau tien cua moi tu trong cau nay
// Capitalize first letter in each word: Hay Viet Hoa Cac Chu Cai Dau Tien Cua Moi Tu Trong Cau Nay
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a sentence:\n\t");
        String text = input.nextLine();
        input.close();

        System.out.print("Capitalize first letter in each word:\n\t");

        for (int i=0; i<=text.length()-1; ++i) {
            // Tạo biến "letter" để lấy ra lần lượt từng ký tự trong câu
            String letter = text.substring(i, i+1); 
            
            // Viết hoa nếu là ký tự đầu tiên của câu
            if (i==0) {
                System.out.print(letter.toUpperCase());
            } 
            // Nếu ký tự ngay phía trước ký tự hiện tại là dấu cách thì viết hoa ký tự hiện tại
            else if (text.substring(i-1, i).equals(" ")) {
                System.out.print(letter.toUpperCase());
            // Các trường hợp còn lại thì viết thường
            } else {
                System.out.print(letter.toLowerCase());
            }
        }
    }
}