package Day03_If_Switch_Loop;

import java.util.Scanner;

public class BTVN_8 {
// BÀI 8:
// Viết chương trình để kiểm tra xem một xâu ký tự đã cho có tất cả các ký tự chỉ xuất hiện 1 lần duy nhất hay không.

// Ví dụ:
// Input a string: xyyzzzabcvg
// All characters are unique? false
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a string:\n\t");
        String text = input.nextLine();
        input.close();

        boolean isUnique = true;
        for (int i=0; i<=text.length()-1; ++i) {
            for (int j=i+1; j<=text.length()-1; ++j) {
                if (text.charAt(i)==text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique == false) {
                break;
            }
        }

        System.out.print("All characters are unique?   " + isUnique);
    }
}