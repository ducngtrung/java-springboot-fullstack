package Day04_Array_Method;

import java.util.Scanner;

public class Day03_BTVN_6_cach_2 {
// Viết chương trình để viết hoa chữ cái đầu tiên của mỗi từ trong câu nhập vào từ bàn phím.

// Ví dụ:
// Input a sentence: hay viet hoa cac chu cai dau tien cua moi tu trong cau nay
// Capitalize first letter in each word: Hay Viet Hoa Cac Chu Cai Dau Tien Cua Moi Tu Trong Cau Nay
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a sentence:\n\t");
        String text = input.nextLine();
        input.close();
    
        // Tách xâu ký tự trên thành một mảng gồm các xâu ký tự con được phân tách bởi dấu cách
        String[] array = text.split(" ");

        System.out.print("Capitalize first letter in each word:\n\t");
        for (int index=0; index<array.length; ++index) {
            // Gán mỗi phần tử của mảng thành một xâu ký tự độc lập (word)
            String word = array[index];
            
            if (word.length() > 0) {
                // Trích xuất ký tự đầu tiên của mỗi word rồi chuyển thành chữ hoa
                String firstCharactor = word.substring(0, 1);
                firstCharactor = firstCharactor.toUpperCase();
                
                // Trích xuất phần còn lại của word rồi chuyển hết thành chữ thường
                String last = word.substring(1);
                last = last.toLowerCase();
                
                // In ra word đã được chuẩn hóa
                System.out.print(firstCharactor + last + " ");
            }
        }
    }
}