// Given an encoded string, return its decoded string.
// The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
// You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

public class LeetCode_394 {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }

    static String decodeString(String s) {
        int iEnd = s.indexOf(']'); // Tìm index của ký tự ']' đầu tiên
        if (iEnd == -1) return s; // Nếu không có ký tự ']' nào thì trả về chuỗi gốc
        int iBegin = s.substring(0, iEnd).lastIndexOf('['); // Tìm index của ký tự '[' ứng với ký tự ']' bên trên
        
        // Tìm start index của số đứng trước ký tự '['
        int i = iBegin;
        while (i > 0 && Character.isDigit(s.charAt(i-1))) {
            --i;
        }

        // Khởi tạo chuỗi kết quả
        StringBuilder resultString = new StringBuilder();
        resultString.append(s.substring(0, i));

        // Nếu có số ở trước ký tự '[' thì nối chuỗi lặp theo số lần lặp
        if (i != iBegin) {
            int timesToRepeat = Integer.parseInt(s.substring(i, iBegin));
            String stringToRepeat = s.substring(iBegin+1, iEnd);
            for (int count = 0; count < timesToRepeat; ++count) {
                resultString.append(stringToRepeat);
            }
        }

        // Nối phần còn lại của chuỗi
        resultString.append(s.substring(iEnd+1));

        return decodeString(resultString.toString());
    }
}