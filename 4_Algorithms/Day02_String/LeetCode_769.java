// Given two strings s and goal.
// Return true if and only if s can become goal after some number of shifts on s.
// A shift on s consists of moving the leftmost character of s to the rightmost position.
//     For example, if s = "abcde", then it will be "bcdea" after one shift.

public class LeetCode_769 {
    public static void main(String[] args) {
        String s = "abcde";
        String goal = "cdeab";
        // String goal = "abced";
        System.out.println(rotateString(s, goal));
    }

    static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        char[] arrS = s.toCharArray();
        int countShift = 0;
        boolean isMatch = false;

        while (!isMatch) {
            // Nếu số lần shift đã bằng độ dài chuỗi thì thoát khỏi vòng lặp
            if (countShift == arrS.length) {
                break;
            }
            
            // Lưu ký tự cuối cùng của mảng arrS ra biến tạm
            char lastChar = arrS[arrS.length-1];
            // Gán ký tự cuối cùng = ký tự đầu tiên
            arrS[arrS.length-1] = arrS[0];
            // Dịch các ký tự còn lại sang trái 1 vị trí
            for (int i = 0; i <= arrS.length-2; ++i) {
                if (i == arrS.length-2) {
                    arrS[i] = lastChar;
                } else {
                    arrS[i] = arrS[i+1];
                }
            }

            ++countShift;
            isMatch = String.valueOf(arrS).equals(goal);
        }

        return isMatch;
    }
}