import java.util.Arrays;

// Given a Roman numeral (in String format), convert it to an integer.

public class LeetCode_13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    static int romanToInt(String s) {
        int[] arr = romanToArray(s);
        int sum = 0;
        for (int i = arr.length-1; i >= 0; --i) {
            if ((i > 0) && (arr[i] > arr[i-1])) {
                sum += arr[i] - arr[i-1];
                --i;
            } else {
                sum += arr[i];
            }
        }
        return sum;
    }

    static int[] romanToArray(String s) {
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case 'I': {
                    arr[i] = 1;
                    break;
                }
                case 'V': {
                    arr[i] = 5;
                    break;
                }
                case 'X': {
                    arr[i] = 10;
                    break;
                }
                case 'L': {
                    arr[i] = 50;
                    break;
                }
                case 'C': {
                    arr[i] = 100;
                    break;
                }
                case 'D': {
                    arr[i] = 500;
                    break;
                }
                case 'M': {
                    arr[i] = 1000;
                    break;
                }
                default: {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}