// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
// Note that after backspacing an empty text, the text will continue empty.

public class LeetCode_844 {
    public static void main(String[] args) {
        String s = "ab##";
        String t = "c#d#";
        // String s = "a#c";
        // String t = "b";

        System.out.println(backspaceCompare(s, t));
    }

    static boolean backspaceCompare(String s, String t) {
        return rebuildString(s).equals(rebuildString(t));
    }

    static String rebuildString(String str) { 
        // Convert chuỗi thành mảng chứa các ký tự
        char[] charArr = str.toCharArray();

        StringBuilder resultString = new StringBuilder();
        for (char ch : charArr) {
            if (ch != '#') { // Nếu không phải ký tự '#' thì nối vào string builder
                resultString.append(ch);
            } else { // Nếu ký tự là '#' và chuỗi hiện tại khác rỗng thì xóa ký tự liền trước
                if (resultString.length() != 0) {
                    resultString.deleteCharAt(resultString.length()-1);
                }
            }
        }   
        return resultString.toString();
    }
}