import java.util.Arrays;

public class Day02_String {
    public static void main(String[] args) {
        String s = "Java123";
        
        // Convert chuỗi thành một mảng các characters
        char[] arr = s.toCharArray();
        System.out.println(Arrays.toString(arr));

        // Convert mảng các characters thành chuỗi
        String s1 = new String(arr);
        System.out.println(s1);
        String s2 = String.valueOf(arr);
        System.out.println(s2);

        // Lấy ra các ký tự là chữ số
        for (char c : arr) {
            if (Character.isDigit(c)) {
                System.out.println(c);
            }
        }

        // In ra ký tự có mã ASCII là 65
        char c = 65;
        System.out.println(c);

        // In ra mã ASCII của ký tự 'a'
        System.out.println((int)'a');

        // Nối chuỗi
        String str = "";
        for (int i = 0; i < 3; ++i) {
            str = str + i + " - ";
        }
        System.out.println(str);

        StringBuilder sb = new StringBuilder("ABC");
        // Nối chuỗi
        sb.append("xyz");
        System.out.println(sb);
        // Chèn vào vị trí bất kỳ trong chuỗi
        sb.insert(2, "123");
        System.out.println(sb);
        // Thay thế một chuỗi ký tự bất kỳ trong chuỗi
        sb.replace(2, 5, "456");
        System.out.println(sb);
        // Đảo ngược chuỗi
        sb.reverse();
        System.out.println(sb);
    }
}
