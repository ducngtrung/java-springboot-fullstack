import java.util.HashMap;
import java.util.Map;

// Given an integer num, convert it to a Roman numeral (in String format)

public class LeetCode_12 {
    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }

    static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        int[] key = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < key.length; ++i) {
            while (key[i] <= num) {
                result.append(map.get(key[i]));
                num -= key[i];
            }
        }
        return result.toString();
    }
}