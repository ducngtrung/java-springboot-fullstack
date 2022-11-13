import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6,3,12,0,9,8,1};
        System.out.println("Mảng ban đầu:");
        System.out.println(Arrays.toString(arr));

        long startTime = System.nanoTime();
        int[] sortedArray = bubbleSort(arr);
        long endTime = System.nanoTime();
        
        System.out.println("Kết quả:");
        System.out.println(Arrays.toString(sortedArray));
        System.out.println("Thời gian chạy: " + (endTime - startTime));
    }
    
    // Dùng vòng lặp để so sánh 2 số liền kề, đẩy các số lớn về cuối mảng
    public static int[] bubbleSort(int[] arr) {
        boolean sorted = false;
        System.out.println("Các lần lặp:");
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < arr.length-1; ++i) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
            System.out.println("\t" + Arrays.toString(arr));
        }
        return arr;
    }
}