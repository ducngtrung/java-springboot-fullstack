// Write a function that reverses an array of characters.
// You must do this by modifying the input array in-place (with no extra memory).

public class LeetCode_344 {
    public static void main(String[] args) {
        char[] s1 = {'h','e','l','l','o'};
        long startTime = System.nanoTime();
        reverseString(s1);        
        long endTime = System.nanoTime();
        System.out.println(s1);
        System.out.println("Thời gian chạy: " + (endTime - startTime));
 
        char[] s2 = {'h','e','l','l','o'};
        startTime = System.nanoTime();
        reverseString(s2, 0, s2.length-1);
        endTime = System.nanoTime();
        System.out.println(s2);
        System.out.println("Thời gian chạy đệ quy: " + (endTime - startTime));
    }

    // Chia đôi mảng rồi hoán đổi vị trí các ký tự đối xứng nhau
    static void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; ++i) {
            char temp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = temp;
        }
    }

    // Sử dụng đệ quy:
    //      biến i chạy từ đầu mảng, biến j chạy từ cuối mảng
    //      đổi chỗ ký tự ở vị trí i và j
    //      điều kiện dừng là j <= i
    static void reverseString(char[] s, int i, int j) {
        if (j <= i) {
            return;
        } else {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            reverseString(s, i+1, j-1);
        }
    }
}