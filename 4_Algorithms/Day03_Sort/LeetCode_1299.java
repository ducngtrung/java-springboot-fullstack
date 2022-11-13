import java.util.Arrays;

// Given an array arr.
// Replace every element in that array with the greatest element among the elements to its right.
// And replace the last element with -1.

public class LeetCode_1299 {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    static int[] replaceElements(int[] arr) {
        // Khởi tạo mảng kết quả có kích thước bằng mảng đầu vào
        int[] resultArr = new int[arr.length];
        
        // Lưu phần tử cuối cùng của mảng ra biến tạm
        int lastElement = arr[arr.length-1];
        
        // Gán phần tử cuối cùng = -1
        resultArr[arr.length-1] = -1;

        for (int i = arr.length-2; i >=0; --i) {
            resultArr[i] = lastElement;
            if (lastElement < arr[i]) {
                lastElement = arr[i];
            }
        }
        return resultArr;
    }
}